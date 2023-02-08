package edu.kh.operator.ex;

public class OperatorEx5 {

	public static void main(String[] args) {
		
		/* 복합 대입 연산자 : +=, -=, *=, /=, %=
		 * */
		
		int a = 10;
		
		a++;
		
		a += 4; // a = a + 4;
		System.out.println(a);
		
		a -= 10; // a = a - 10;
		System.out.println(a);
		
		a *= 3; // a = a * 3;
		System.out.println(a);
		
		a /= 6; // a = a / 6;
		System.out.println(a);
		
		a %= 2; // a = a % 2;
		System.out.println(a);
		
	}
}
