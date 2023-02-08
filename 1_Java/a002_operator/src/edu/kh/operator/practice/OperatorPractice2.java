package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름 : ");
		String name = sc.next();
		
		System.out.println("학년(정수) : ");
		int grade = sc.nextInt();
		
		System.out.println("반(정수) : ");
		int classN = sc.nextInt();
		
		System.out.println("번호(정수) : ");
		int number = sc.nextInt();
		
		System.out.println("성별(남학생/여학생) : ");
		String gender = sc.next();
		
		System.out.println("성적(소수점 둘째 자리까지) : ");
		double score = sc.nextDouble();
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다."
				, grade, classN, number, name, gender, score);
	}
}
