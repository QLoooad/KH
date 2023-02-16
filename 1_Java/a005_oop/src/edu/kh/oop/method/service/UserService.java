package edu.kh.oop.method.service;

import edu.kh.oop.method.dto.User;
import edu.kh.oop.method.view.UserView;

public class UserService {
	

	//	1. 회원가입
	public User signUp(String userId, String userPw, String userPwConfirm, 
					   String userName, char userGender ){
		//전달 받은 값 중 비밀번호, 비밀번호 확인이 일치할 경우
		//user 객체를 생성해서 주소를 반환
		//만약 일치하지 않은 경우 null 반환
		
		User user = null; // 아무것도 참조하지 않음
		
		//비번, 비번확인 일치할 경우
		if(userPw.equals(userPwConfirm)) {
			// User 객체 생성 후 주소를 user에 저장
			user = new User(userId, userPwConfirm, userName, userGender);
		}
		
		
		return user; //주소 또는 null
	}
	
	//	2. 로그인
	public void login(String userId, String userPw, User signUpUser) {
							//입력 받은 값          //가입한 회원 정보
		
		//아이디 일치 여부 검사
		boolean idCheck = userId.equals(signUpUser.getUserId());
		boolean pwCheck = userPw.equals(signUpUser.getUserPw());
		
		if(idCheck && pwCheck) {
			//로그인 처리
			//UserView에 있는 클래스 변수(static) loginuser에 
			//가입한 회원의 정보를 가지고 있는 객체의 주소를 대입
			UserView.loginUser = signUpUser;
		}
	}
	
	//	5. 회원 정보 수정
	public boolean userUpdate(String userName, char userGenderm, String userPw) {
		
		//비밀번호 일치 여부 확인
		//	! << 비밀번호 같지 않을때 (equals 는 앞에 !, == 는 !=)
		if(!UserView.loginUser.getUserPw().equals(userPw)) {
			
			return false;
		}
		
		//비밀번호가 일치할 때
		//로그인한user 정보에 전달 받은 값 세팅
		UserView.loginUser.setUserName(userName);
		UserView.loginUser.setUserGender(userGenderm);
		return true;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
