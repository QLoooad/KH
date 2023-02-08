package edu.kh.variable;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		
		System.out.print("정수 입력 1 : ");
		
		int input1 = sc.nextInt();
		
		System.out.println(input1);
		
		System.out.print("정수 입력 2 : ");
		
		int input2 = sc.nextInt();
		
		System.out.printf("%d + %d = %d",input1,input2,input1 + input2);
		
	}

}
