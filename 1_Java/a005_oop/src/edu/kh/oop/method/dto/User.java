package edu.kh.oop.method.dto;


//DTO (Data Transfer Object) : 값 전달용 객체
public class User {

	//id, pw, name, gender(M/F)
	//private : 외부 접근차단(캡슐화 원칙 적용)
	private String userId;
	private String userPw;
	private String userName;
	private char userGender;
	
	//생성자
	
	public User() {} //기본 생성자
		
	public User(String userId, String userPw, String userName, char userGender) {
		
		//자기자신 참조
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userGender = userGender;
	}
	
	//메서드
	// toString() : 객체가 가지고 있는 모든 필드 값을 하나의 문자열로 표기 반환
	public String toString() {
		return String.format("%s / %s / %s / %c", userId, userPw, userName, userGender);
	}
	
	
	//getter setter
	//캡슐화 원칙에 의해 직접 접근이 차단된 필드와
	//데이터 교환을 할 수 있는 기능(간접 접근 방법)
	
	//getter
//	public 반환형 get필드명(){
//	
//		return 필드명;
//	}
	
	//setter
//	public void set필드명(자료형 필드명) {
//		this.필드명 = 필드명;
//	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char getUserGender() {
		return userGender;
	}

	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
