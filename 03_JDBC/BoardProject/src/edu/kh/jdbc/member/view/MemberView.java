package edu.kh.jdbc.member.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.view.BoardView;
import edu.kh.jdbc.common.Session;
import edu.kh.jdbc.member.model.dto.Member;
import edu.kh.jdbc.member.model.service.MemberService;

/**
 * 회원 전용 화면
 * 
 * @author 이름(이메일)
 * 
 */
public class MemberView {

	private Scanner sc = new Scanner(System.in);

	// 회원 기능 화면 객체 생성
	private MemberService service = new MemberService();
	


	// 230327 테스트
	/**
	 * 회원 기능 메뉴
	 */
	public void memberMenu() {

		int input = 0;
		do {
			try {
				System.out.println("\n===== 회원 기능 =====\n");
				System.out.println("1. 내 정보 조회");
				System.out.println("2. 회원 목록 조회(아이디, 이름, 성별)");
				System.out.println("3. 내 정보 수정(이름, 성별)");
				System.out.println("4. 비밀번호 변경(현재 PW, 새 PW, 새 PW 확인)");
				System.out.println("5. 회원 탈퇴(보안코드, PW, UPDATE)");

				System.out.println("9. 메인메뉴로 돌아가기");
				System.out.println("0. 프로그램 종료");

				System.out.println("\n메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();

				switch (input) {
				case 1: selectMyInfo(); break;
				case 2: selectMemberList(); break;
				case 3: updateMember(); break;
				case 4: updatePw(); break;
				case 5: 
					if(unRegisterMember()) {
						return;
					}
					break;
				case 6:  break;
				case 7:  break;
				case 8:  break;
				case 9:
					System.out.println("\n===== 메인 메뉴로 돌아갑니다. =====\n");
					break;
				case 0:
					System.out.println("\n*** 프로그램 종료 ***\n");
					System.exit(0);// JVM 강제 종료
					// 매개변수 기본 0
					// 다른 숫자는 오류를 의미함

				default:
					System.out.println("\n*** 메뉴 번호만 입력 해주세요. ***\n");
				}

			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println("\n*** 입력 형식이 올바르지 않습니다. ***\n");
				sc.next();
				input = -1;

			}

		} while (input != 9);

	}

	/** 회원 탈퇴
	 * @return true/ false
	 */
	private boolean unRegisterMember() {

		System.out.println("\n===== 회원 탈퇴 =====\n");
		
		System.out.println("\n===== 현재 비밀번호 입력 =====\n");
		String nowPw = sc.next();
		
		String code = service.createSecurityCode();
		System.out.printf("보안문자 입력 [%s]: ", code);
		String input = sc.next();

		// 보안문자 일치여부 확인
		if(!input.equals(code)) {
			System.out.println("\n*** 보안문자가 일치하지 않습니다. ***\n");
			return false;
		}
		
		while (true) {
			System.out.println("정말 탈퇴 하시겠습니까?(Y/N)");
			 char check = sc.next().toUpperCase().charAt(0);
			 
			 if(check == 'N') {
				 System.out.println("\\n===== 탈퇴 취소 =====\\n");
				 return false ; // 메서드 종료
			 }
			 if(check == 'Y') {
				 break; // 반복문 종료
			 }
			 System.out.println("\n*** 잘못 입력 하셧습니다. ***\n");
		}
		
		try {
			int result = service.unRegisterMember(nowPw, Session.loginMember.getMemberNo());
			if (result > 0) {
				System.out.println("\n===== 탈퇴 =====\n");
			} else {
				System.out.println("\n*** 비밀번호가 일치하지 않습니다. ***\n");
			}
			// 로그아웃
			Session.loginMember = null;
			
			return true;
			
		} catch (Exception e) {
			System.out.println("\n*** 회원 탈퇴 중 예외 발생 ***\n");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 비밀번호 변경
	 */
	private void updatePw() {
		System.out.println("\n===== 비밀번호 변경 =====\n");

		// 현재 비밀번호 입력
		System.out.println("\n===== 현재 비밀번호 입력 =====\n");
		String nowPw = sc.next();
		String newPw = null;
		String reNewPw = null;
		while (true) {
			// 새 비밀번호 입력
			System.out.println("\n===== 새 비밀번호 입력 =====\n");
			newPw = sc.next();
			// 새 비밀번호 확인 입력
			System.out.println("\n===== 새 비밀번호 확인 입력 =====\n");
			reNewPw = sc.next();
			// 같을 때 까지 무한반복
			if (newPw.equals(reNewPw)) {
				break;
			}
			System.out.println("\n*** 변경할 비밀번호를 다시 한번 확인해주세요. ***\n");
		}

		try {
			int result = service.updatePw(nowPw,newPw, 
					Session.loginMember.getMemberNo());
			// 서비스 호출(현재 비밀번호, 새 비밀번호, 로그인한 회원 번호)
			// > 성공 1 / 실패 0
			if (result > 0) {
				System.out.println("\n===== 비밀번호가 변경되었습니다. =====\n");
			} else {
				System.out.println("\n*** 현재 비밀번호가 일치하지 않습니다. ***\n");
			}
		} catch (Exception e) {
			System.out.println("\n*** 비밀번호 변경 중 예외 발생 ***\n");
			e.printStackTrace();

		}

	}

	/**
	 * 이름, 성별 수정
	 */
	private void updateMember() {
		System.out.println("\n===== 내 정보 수정 =====\n");
		// 이름(VARCHAR2), 성별(CHAR, M/F)

		System.out.print("수정할 이름 : ");
		String memberName = sc.next();

		String memberGender;
		while (true) {
			System.out.print("수정할 성별(M/F) : ");
			memberGender = sc.next().toUpperCase();
			if (memberGender.equals("M") || memberGender.equals("F")) {
				break;
			}
		}

		try {
			int result = service.updateMember(memberName, memberGender, Session.loginMember.getMemberNo());

			if (result > 0) {
				System.out.println("\n===== 수정 완료 =====\n");
				// Service를 호출해서 DB만 수정
				// > DB와 Java프로그램 데이터 초기화
				Session.loginMember.setMemberName(memberName);
				Session.loginMember.setMemberGender(memberGender);

				return;
			} else {
				System.out.println("\n*** 수정 실패 ***\n");
				return;
			}
		} catch (Exception e) {
			System.out.println("\\n*** 내 정보 수정 중 예외 발생 ***\\n");
			e.printStackTrace();
		}
		// Session.loginMember.getMemberNo() 로그인한 회원의 번호
		// service 호출 > DAO 호출 > UPDATE 수행 > UPDATE가 진행된 행 개수 (INT)
	}

	/**
	 * 회원 목록 조회
	 */
	private void selectMemberList() {
		System.out.println("\n===== 회원 목록 조회 =====\n");

		try {
			// 회원 목록 조회 서비스 호출 후 결과 반환 받기
			List<Member> memberList = service.selectMemberList();

			if (memberList.isEmpty()) {
				System.out.println("\n===== 조회 결과가 없습니다. =====\n");
				return;
			}

			for (int i = 0; i < memberList.size(); i++) {
				System.out.printf("%d\t%s\t%s\t%s\n", i + 1, memberList.get(i).getMemberId(),
						memberList.get(i).getMemberName(), memberList.get(i).getMemberGender());
			}

		} catch (Exception e) {
			System.out.println("\\n*** 회원 목록 조회 중 예외 발생 ***\\n");
			e.printStackTrace();
		}

	}

	/**
	 * 내 정보 조회
	 */
	private void selectMyInfo() {

		System.out.println("\n===== 내 정보 조회 =====\n");
		// 회원번호, 아아디, 이름 , 성별(남.ㅇ/), 가입일
		System.out.println("회원 번호 : " + Session.loginMember.getMemberNo());
		System.out.println("ID : " + Session.loginMember.getMemberId());
		System.out.println("이름 : " + Session.loginMember.getMemberName());
		if (Session.loginMember.getMemberGender().equals("M")) {
			System.out.println("성별 : 남");
		} else {
			System.out.println("성별 : 여");
		}
		System.out.println("가입일 : " + Session.loginMember.getEnrollDate());
	}

}
