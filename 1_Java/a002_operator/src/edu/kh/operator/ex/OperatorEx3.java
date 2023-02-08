package edu.kh.operator.ex;

public class OperatorEx3 {

	public static void main(String[] args) {
		
		/* 논리연산자
		 * 
		 * && and  둘다 true 이여야만 true
		 * || or   하나만 true 여도 true
		 * */
		
		int num1 = 98;
		
		boolean result1 = num1 >= 100 && num1 % 2 == 0; //false
		
		// 정수 50이하 and 3배수 인가
		int num2 = 42;
		boolean result2 = num2 <= 50 && num2 % 3 == 0;
		
		
		int num3 = 20;
		boolean result3 = num3 > 10 || num3 % 2 == 1;//true
		
		
		//0~50사이 수 또는 음수인가?
		int num4 = 3;
		boolean result4 = num4 >= 0 && num4 <= 50 || num4 <= -1 ;
		// num4 <= 50; << 이거도 됨
		System.out.println(result4);
		
	}
}
