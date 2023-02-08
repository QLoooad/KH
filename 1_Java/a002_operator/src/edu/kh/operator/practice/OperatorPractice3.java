package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		System.out.println(Math.abs(num1)  == 0 ? "0 입니다."
				: num1 > 0 ? "양수입니다." : "음수입니다.");
	}
}