package edu.kh.polymorphism.ex2.dto;

public interface KH {	//인터페이스
	
	//상수형 필드 (public static final)만 작성 가능
	/*public static final*/ String KH_ADDRESS = "서울시 중구 남대문로 120 2층";
	//인터페이스 필드는 무조껀 상수형 필드이기에 public static final를 적지 않아도
	//묵시적(암묵적)으로 public static final 기본 적용
	int A = 90;
	
	
	//추상 메서드
	//인터페이스는 추상 클래스의 변형체로
	//모든 메서드가 public abstract (추상 메서드)다
	
	//인터페이스의 모든 메서드는 묵시적으로 public abstract(추상 메서드)
	
	//단, default 메서드, static 메서드는 abstract가 아님
	
	/*public abstract*/ void lesson();
	
	
	
	
	
	
	
	
	
	
}
