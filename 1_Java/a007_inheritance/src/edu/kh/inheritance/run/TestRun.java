package edu.kh.inheritance.run;

import edu.kh.inheritance.dto.Child1;
import edu.kh.inheritance.dto.Child2;
import edu.kh.inheritance.dto.Parent;

public class TestRun {
	public static void main(String[] args) {
		
		//부모, 자식1,2 객체 생성
		
		Parent p = new Parent(1_000_000_000, "김");
		
		Child1 c1 = new Child1("테슬라");
		Child2 c2 = new Child2("시그니엘");
		
		
		
		
		//	상속(extends)
		//	- 부모 클래스가 가지고있는 필드, 메소드를
		//	  자식 클래스가 자신의 것 처럼 사용 가능하게 하는 기술
		
		System.out.println(c1.getMoney());
		System.out.println(c1.getLastName());
		
		System.out.println(c2.getMoney());
		System.out.println(c2.getLastName());
		// > 부모의 메소드 상속 확인
		
//		System.out.println(c1.money);
		// 부모의 private 접근 제한자는 상속을 받아도 직접 접근 불가능
		// private 필드/메서드는 상속이 되어 있음
		//	단, 자식도 접근만 못할뿐이다.(private는 같은 클래스만 접근 가능)
		
		//부모 클래스이 코드를 수정하면
		//자식 모두에게 적용된다(공통적인 규약, 유지보수성 향상)
		
		
		
		System.out.println("---------------------------");
		//toString() : 객체가 가지고있는 필드를 하나의 문자열로 만들어서 반환
		System.out.println(c1.toString());
		
	}

}
