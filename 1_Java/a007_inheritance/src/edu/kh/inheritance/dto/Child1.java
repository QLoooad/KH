package edu.kh.inheritance.dto;


					//확장  Parent의 코드를 Child1 에게 상속
public class Child1 extends Parent {

	
	private String car;
	
	public Child1() {
		
//		super();//super() 생성자
				//자식 객체 생성 시 부모 객체를 먼저 생성하게 함
				//미작성 시 컴파일러가 자동 추가
		System.out.println("Child1() 기본 생성자");
	}
	
	public Child1(String car) {
		
		//super();//super() 생성자
				//자식 객체 생성 시 부모 객체를 먼저 생성하게 함
				//미작성 시 컴파일러가 자동 추가
		//부모로 부터 상속받은 setter를 이용해 부모 필드를 초기화
		//setMoney(100_000_000);
		//setLastName("김");
		
		//부모의 필드를 초기화 하는 방법이 부모 매개변수 생성자에 존재
		//이를 호출해서 사용(코드길이 감소, 재사용성의 증가)
		super(200_000_000, "배");
		this.car = car;
		System.out.println("Child1(String) 매개변수 생성자");
	}
	
	public String getCar() {
		return car;
	}
	
	public void setCar(String car) {
		this.car = car;
	}
	
	public String toString() {
//		Parent p1 = new parent();
//		p1.getMoney();
		
//		자신의 (같은 클래스) 메서드 호출 시 이름만 부르면 된다
//		 + 상속 특징(부모 필드/메서드를 상속 받아 자식 것 처럼 사용)
//		System.out.println(getCar());
//		System.out.println(getMoney());
//		System.out.println(getLastName());
		
		//부모의 필드 값을 간접 접근 방법으로 얻어와 하나의 문자열로 만들어 반환
//		return car + " / " +getMoney() + " / " + getLastName();
		
		//StackOverflowError 발생
		//Child1의 toString() 호출 시 ()
		//자신의(Child1) toString()를 호출해서 반복된다
		//재귀호출(재귀함수)
//		return car + " / " + toString();
		
		//해결 방법
		return car + " / " + super.toString();
		
	}
	
	
	
	//부모의 getMoney()존재
	/*
	 	public int getMoney() {
		return money;
	}
	 */
	//자식이 상속 받은 getMoney()를 다시 작성(재정의)
	
	//@Override
	//컴파일러에게 해당메서드는 재정의 되었다는 것을 알려주는 컴퓨터용 주석
	//> 오버라이딩 형식이 맞는지 검사 진행
	
//	조건
//	- 메소드 이름 동일
//	- 매개변수의 개수, 타입, 순서 동일
//	- 리턴 타입 동일
//	- private 메소드 오버라이딩 불가
//	- 접근 제어가는 부모와 같거나 넓은 범위로 변경 가능
//	- 예외처리는 부모와 같거나 좁은 범위로 예외처리 변경 가능
	
	@Override
	public int getMoney() {
		System.out.println();
		System.out.println("자식이 오버라이딩한 getMoney() + 500");
		return super.getMoney() + 500;
	}
	
	
	
	
	
	
	
}
