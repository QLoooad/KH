package edu.kh.jdbc.board.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.dto.Board;
import edu.kh.jdbc.board.model.service.BoardService;
import edu.kh.jdbc.common.Session;

public class BoardView {
	
	private Scanner sc = new Scanner(System.in);
	private BoardService boardService = new BoardService();
	
	   public void boardMenu() {
		      
		      int input = -1;
		      
		      do {
		         try {
		            System.out.println("\n===== 게시판 기능 =====\n");
		            System.out.println("1. 게시글 목록 조회");
		            System.out.println("2. 게시글 상세 조회(+ 댓글 기능)");
		            System.out.println("3. 게시글 작성");
		            System.out.println("4. 게시글 검색");
		            System.out.println("9. 메인 메뉴로 돌아가기");
		            System.out.println("0. 프로그램 종료");
		            
		            System.out.print("\n메뉴 선택 : ");
		            input = sc.nextInt();
		            sc.nextLine(); 
		            
		            System.out.println();
		            
		            switch(input) {
		            case 1: selectAllBoard();  break; // 게시글 목록 조회
		            case 2: selectBoard(); break; // 게시글 상세 조회
		            case 3: insertBoard(); break; // 게시글 등록(삽입)
		            // 제목 내용(sb 사용)
		            // >  게세글 삽입 서비스
//		            case 4: searchBoard(); break; // 게시글 검색
		            case 9: 
		               System.out.println("\n===== 메인 메뉴로 돌아갑니다 =====\n");
		               break;
		            
		            case 0: 
		               System.out.println("\n=== 프로그램 종료 ===\n"); 
		               System.exit(0);
		            default: System.out.println("\n*** 메뉴 번호만 입력 해주세요 ***\n");  
		            }
		            
		            System.out.println();
		            
		         }catch (InputMismatchException e) {
		            System.out.println("\n*** 입력 형식이 올바르지 않습니다***\n");
		            sc.nextLine(); // 입력버퍼에 잘못된 문자열 제거
		            input = -1; // while문 종료 방지
		         }
		         
		      }while(input != 9);
		      
		   }

	/**
	 * 게시글 등록(INSERT)
	 */
	private void insertBoard() {
		System.out.println("\n===== 게시글 등록 =====\n");
		
		// 제목 입력
		System.out.print("제목 : ");
		String boardTitle = sc.nextLine();
		// 내용 입력
		System.out.print("내용 : ");
		StringBuffer sb = new StringBuffer();
		
		// 특정 단어가 입력 될 때 까지 무한히 입력
		System.out.println("< !wq 입력시 종료>");
		while(true) {
			String str = sc.nextLine();
			if(str.equals("!wq")) break;
			
			sb.append(str + "\n");
//			sb.append("\n");
		}
		try {
			// 게시글 삽입 서비스 호출
			int result = boardService.insertBoard(boardTitle, sb.toString(),
					Session.loginMember.getMemberNo());
			
			if(result > 0) {
				System.out.println("\n===== 게시글 등록 완료 =====\n");
				// 등록된 게시글 상세 내용 표시
				Board board = boardService.selecBoard(result, Session.loginMember.getMemberNo());
				
		        System.out.println("--------------------------------------------------------");
		        System.out.printf("글번호 : %d \n제목 : %s\n", board.getBoardNo(), board.getBoardTitle());
		        System.out.printf("작성자 : %s | 작성일 : %s  \n조회수 : %d\n", 
		              board.getMemberName(), board.getCreateDate(), board.getReadCount());
		        System.out.println("--------------------------------------------------------\n");
		        System.out.println(board.getBoardContent());
		        System.out.println("\n--------------------------------------------------------");
			}else {
	            System.out.println("\n*** 게시글 등록 실패 ***\n");
			}
			
		} catch (Exception e) {
			
			System.out.println("\n*** 게시글 상세 조회 중 예외 발생 ***\n");
		}
		
	}

	private void selectBoard() {
		System.out.println("\n===== 게시글 상세 조회 =====\n");
		// 게시글 번호 입력
		// 1) 번호가 일치하는 게시글이 있으면 조회
		//  > 조회수 증가(단, 자신이 작성한 게시글일 경우 조회수 증가 x)
		
		// 2) 번호가 일치하는 게시글이 없으면
		// > 해당 게시글이 존재하지 않습니다.
		
		System.out.print("게시글 번호 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		// 게시글 상세 조회서비스
		try {
			Board board = boardService.selecBoard(input, Session.loginMember.getMemberNo());
			
			if(board == null) {// 게시글이 없
				System.out.println("해당 게시글이 존재하지 않습니다.");
				return;
			}
		
        System.out.println("--------------------------------------------------------");
        System.out.printf("글번호 : %d \n제목 : %s\n", board.getBoardNo(), board.getBoardTitle());
        System.out.printf("작성자 : %s | 작성일 : %s  \n조회수 : %d\n", 
              board.getMemberName(), board.getCreateDate(), board.getReadCount());
        System.out.println("--------------------------------------------------------\n");
        System.out.println(board.getBoardContent());
        System.out.println("\n--------------------------------------------------------");
		
        // 작성자 본인 게시글일 경우
        // 게시글 수정/삭제 기능 노출
        
        if(Session.loginMember.getMemberNo() == board.getMemberNo()) {
        	while(true) {
	        	System.out.println("1. 수정\n"
				        			+ "2. 삭제\n"
				        			+ "0. 게시판 메뉴로 돌아가기\n");
	        	System.out.print("선택 >> ");
	        	input = sc.nextInt();
	        	sc.nextLine();
	        	
	        	// 기능 수행 후 게시판 메뉴로 돌아가기
	        	switch(input) {
	        	//	게시글 번호 매개변수
	        	case 1 : updateBoard(board.getBoardNo()); return;
	        	case 2 : deleteBoard(board.getBoardNo()); return;
	        	case 0 : return;
	        	default : System.out.println("\n*** 잘못 입력 하셧습니다. ***\n");
	        	}
        	}
        }
		} catch (Exception e) {
            System.out.println("\n*** 게시글 상세 조회 중 예외 발생 ***\n");
			e.printStackTrace();
		}
	}

	private void deleteBoard(int boardNo) {
		System.out.println("\n===== 게시글 삭제 =====\n");
		
		while(true) {
			System.out.print("정말 삭제 하시겠습니까? (Y/N) : ");
			char check  = sc.next().toUpperCase().charAt(0);
			
			if(check == 'N') {
				System.out.println("[삭제 취소]");
			}
			if(check != 'Y') {
				System.out.println("잘못 입력 하셧습니다.");
				continue;
			}
			break; // 'Y'
		}
		// 게시글 삭제 서비스 호출	
		try {
			int result = boardService.deleteBoard(boardNo);
			
			if(result > 0) {
				System.out.println("\n===== 게시글 삭제 완료 =====\n");
			}else {
	            System.out.println("\n*** 게시글 삭제 실패 ***\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
            System.out.println("\n*** 게시글 삭제 중 예외 발생 ***\n");
		}
		
		
	}

	/** 게시글 수정
	 * @param boardNo
	 */
	private void updateBoard(int boardNo) {
		System.out.println("\n===== 게시글 수정 =====\n");
		
		System.out.println("수정할 제목 : ");
		String boardTitle = sc.nextLine();
		
		StringBuffer sb = new StringBuffer();
		
		// 특정 단어가 입력 될 때 까지 무한히 입력
		System.out.println("< !wq 입력시 종료>");
		while(true) {
			String str = sc.nextLine();
			if(str.equals("!wq")) break;
			
			sb.append(str + "\n");
//			sb.append("\n");
		}
		// 게시글 수정 서비스 호출
		try {
			int result = boardService.updateBoard(boardTitle, sb.toString(), boardNo);
			if(result > 0) {
				System.out.println("\n===== 게시글 수정 완료 =====\n");
			}else {
	            System.out.println("\n*** 게시글 수정 실패 ***\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
            System.out.println("\n*** 게시글 수정 중 예외 발생 ***\n");
		}
		
	}

	private void selectAllBoard() {
		System.out.println("\n===== 게시글 목록 조회 =====\n");
		
		try {
			// 게시글 목록 조회 서비스 호출
			List<Board> boardList = boardService.selectAllBoard();
			
			if(boardList.isEmpty()) {// 게시글 없
	            System.out.println("\n*** 게시글이 존재하지 않습니다. ***\n");
				return;
			}
			
			for(Board a : boardList) {
				System.out.printf("%d | %s[%d] | %s | %s | %d \n",
						a.getBoardNo(), a.getBoardTitle(), a.getCommentCount(),
						a.getMemberName(), a.getCreateDate(), a.getReadCount());
			}
		} catch (Exception e) {
			e.printStackTrace();
            System.out.println("\n*** 게시글 목록 조회 중 예외 발생 ***\n");
		}
		
	}
	
}
