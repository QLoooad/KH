package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("인원 수 입력 : ");
		int human = sc.nextInt();
		
		System.out.println("사탕 개수 입력 : ");
		int candy = sc.nextInt();
		
		System.out.println("1인당 사탕 개수 : " + (candy / human));
		System.out.println("남은 사탕 개수 : " + (candy % human));
		
	}

}
