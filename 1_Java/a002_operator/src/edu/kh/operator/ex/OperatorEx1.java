package edu.kh.operator.ex;

import java.util.Scanner;

public class OperatorEx1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//산술연산자 + - * / %(modulo, mod) 
		
		System.out.println("두 정수를 입력받아 산술 연산 결과 출력");
		
		System.out.println("정수 입력 1 : ");
		int input1 = sc.nextInt();
		
		System.out.println("정수 입력 2 : ");
		int input2 = sc.nextInt();
		
		System.out.printf("%d + %d = %d \n", input1, input2, input1 + input2);
		
		System.out.printf("%d - %d = %d \n", input1, input2, input1 - input2);
		
		System.out.printf("%d * %d = %d \n", input1, input2, input1 * input2);
		
		System.out.printf("%d / %d = %d \n", input1, input2, input1 / input2);
		
		System.out.printf("%d %% %d = %d \n", input1, input2, input1 % input2);
	}

}
