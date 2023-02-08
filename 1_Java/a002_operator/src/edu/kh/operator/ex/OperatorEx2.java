package edu.kh.operator.ex;

public class OperatorEx2 {

	public static void main(String[] args) {
		
		/* 증감 연산자 : ++, --
		 * 
		 * 
		 * 전위 연산 : ++a;	a 증가 후 다음 연산 실행
		 * 후위 연산 : a++;	a 우선 실행 후 연산 끝나면 a증가 
		 * */
		
		int num1 = 10;
		int num2 = 10;
		
		System.out.printf("[연산 전] num1 : %d / num2 : %d \n", num1, num2);
		
		num1++;
		num2--;
		
		System.out.printf("[연산 후] num1 : %d / num2 : %d \n", num1, num2);
		System.out.println("-------------------------------------------------------------");
		
		int num3 = 5;
		
		System.out.println("++num3 : "+ (++num3));		//5
		System.out.println("num3++ : "+ (num3++)+1);	
		
		//후위 연산
		int num4 = 1;
		System.out.println("num4-- : " + (num4--));
		
		System.out.println("num4++ -3 : " + (num4++ -3)); //-3
		System.out.println("연산 후 num4 : " + num4); //1
		
		int a = 3;
		int b = 5;
		int c = a++ + --b; 
		// a = 4, b = 4, c = 7
		System.out.println(c);
	}
}
