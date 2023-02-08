package edu.kh.variable;

public class VariableEx1 {

	public static void main(String[] args) {

		System.out.println("[변수사용 x]");
		System.out.println(2*3.141592653589793*10);//원의 둘레
		System.out.println(3.141592653589793*10*10);//원의 넓이
		System.out.println(3.141592653589793*10*10*20);//원기둥의 부피
		System.out.println(4*3.141592653589793*10*10);//구의 겉넓이
		System.out.println("-----------------------");
		
		double pi = 3.141592653589793;
		int r = 10;
		int h = 20;
		System.out.println("[변수사용]");
		System.out.println(2*pi*r);//원의 둘레
		System.out.println(pi*r*r);//원의 넓이
		System.out.println(pi*r*r*h);//원기둥의 부피
		System.out.println(4*pi*r*r);//구의 겉넓이
		/* 변수란
		 * 메모리(ram)에 값 기록 공간
		 * 공간에 기록되는 값이 변할 수 있어서 변수라 지칭
		 * */
		
		
		/*변수 사용 장점
		 * 1. 코드작성 용이(편리,쉽다,코드길이감소)
		 * 2. 가독성 향상(읽기 편함)
		 * 3. 재사용성 증가
		 * 4.유지보수 용이(유지보수성향상,수정쉬움)
		 * */
	}

}
