package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 : ");
		int num1 = sc.nextInt();
		
		System.out.println("영어 : ");
		int num2 = sc.nextInt();
		
		System.out.println("수학 : ");
		int num3 = sc.nextInt();
		
		int sum = num1 + num2 + num3;
		double average = sum/3.0;
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + average);
		
		if(num1 >= 40 && num2 >= 40 && num3 >= 40) {
			if(average >= 60) {
				System.out.println("합격");
			}else {
				System.out.println("불합격");
			}
		}else {
			System.out.println("불합격");
		}
	}

}
