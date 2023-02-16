package edu.kh.oop.method.view;

import java.util.Scanner;

import edu.kh.oop.method.dto.User;
import edu.kh.oop.method.service.UserService;

//	입/출력용 객체를 만들기 위한 클래스
public class UserView {
	
	private Scanner sc = new Scanner(System.in);
	//기본생성자(매개변수가 없어서)
	private UserService service = new UserService();
	
	//가입한 사용자 정보를 가지고 있는 객체를 참조할 변수 선언
	private User signUpUser = null;
	
	public UserView() {
		//	기본 생성자로 객체 생성 시
		//	UserView.loginUser에 객체 주소 대입하기
		signUpUser = new User("123", "456", "테스트", 'F');
	}
	
	
	//로그인 한 사용자 정보를 가지고 있는 객체를 참조할 변수 선언
	//프로그램 시작 시 static 영역에 생성
	// >> 어디서든지 클래스명.필드명 으로 접근 가능
	public static User loginUser = null;
	
	public void displayMenu() {
		
		int input = 0; //입력한 메뉴 번호를 저장할 변수
		
		do {
			System.out.println("----- 사용자 기능 메뉴 -----");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 로그아웃");
			System.out.println("4. 회원 정보 출력");
			System.out.println("5. 회원 정보 수정");
			System.out.println("0. 프로그램 종료");
			System.out.println("----------------------------");
			
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			System.out.println();
			
			switch(input) {
			case 1 : singUp(); break;
			case 2 : login(); break;
			case 3 : logout(); break;
			case 4 : userPrint(); break;
			case 5 : userUpdate(); break;
			case 0 : System.out.println("<프로그램 종료>"); break;
			default : System.out.println("잘못 입력 하셧습니다.");
			}
			
			System.out.println();
			
		}while(input != 0);
		
	}
	
	//1. 회원가입
	private void singUp() {
		System.out.println("*** 회원가입 ***");
		System.out.print("ID : ");
		String userId = sc.next();
		
		System.out.print("PW : ");
		String userPw = sc.next();
		
		System.out.print("PW 확인 : ");
		String userPwConfirm = sc.next();
		
		System.out.print("이름 : ");
		String userName = sc.next();
		
		//	.charAt(i)  i번째를 char 로 변경
		//	- 문자열에서 지정된 인덱스번째 문자하나를 char로 변환
		System.out.print("성별(M/F)");
		char userGender = sc.next().charAt(0);
		
		//signUpUser = User 객체 주소 또는 null
		signUpUser = service.signUp(userId, userPw, userPwConfirm, userName, userGender);
		
		if(signUpUser != null) { //signUpUser가 참조를 하고 있는경우
								// == 주소가 저장된 경우
			System.out.println("[[회원가입 성공]]");
		}else {
			System.out.println("[비밀번호가 일치하지 않습니다.]");
		}
	}
	
	//로그인
	private void login() {
		//void : 반환값이 없다 (return 은 존재)
		
		System.out.println("*** 로그인 ***");
		
		//회원가입된 User가 없을 경우
		if(signUpUser == null) {
			System.out.println("[먼저 회원가입 후 진행해주세요.]");
			return; //현재 메소드 종료 후 호출한 곳으로 돌아감
		}
		
		System.out.print("ID : ");
		String userId = sc.next();
		
		System.out.print("PW : ");
		String userPw = sc.next();
		
		//	입력 받은 값 + signUpUser를 Service의 login 메소드로 전달하여
		//	아이디 비번 일치 시 로그인
		
		service.login(userId, userPw, signUpUser);
		
		//로그인 성공 여부 확인
		if(UserView.loginUser != null) {
			System.out.println(UserView.loginUser.getUserName() + "님 환영합니다.");
		}else {
			System.out.println("[아이디 또는 비밀번화 일치하지 않습니다.");
		}
		
	}
	
	private void logout() {
		//로그인 상태인 경우 로그아웃을 수행
		if(UserView.loginUser != null) {
			UserView.loginUser = null;
			System.out.println("[로그아웃 되었습니다.]");
		}else {
			System.out.println("[로그인 후 이용해주세요.]");
		}
	}
	
	//회원정보 출력
	private void userPrint() {
		//로그인 확인
		System.out.println("*** 회원 정보 출력 ***");
		if(UserView.loginUser != null) {
			System.out.println(UserView.loginUser.toString());
		}else {
			System.out.println("[로그인 후 이용해주세요.]");
		}
	}
	//회원 정보 수정
	private void userUpdate() {
		System.out.println("*** 5. 회원 정보 수정 ***");
		
		if(UserView.loginUser != null) {
			//이름, 성별만 변경 가능
			//단, 비밀번호 일치해야 가능
			
			System.out.print("이름 : ");
			String userName = sc.next();
			
			System.out.print("성별(M/F)");
			char userGender = sc.next().charAt(0);
			
			System.out.println("PW : ");
			String userPw = sc.next();
			
			//service의 회원 정보 수정 메소드 호출
			//userUpdate가 boolean이라 true/ false 반환
			if(service.userUpdate(userName, userGender, userPw)) {
				//수정 성공
				System.out.println("[회원 정보가 수정되었습니다.]");
			}else {
				//수정 실패 시
				System.out.println("[비밀번호가 일치하지 않습니다.]");
			}
			
			
		}else {
			System.out.println("[로그인 후 이용해주세요.]");
		}
		
		
	}
}
