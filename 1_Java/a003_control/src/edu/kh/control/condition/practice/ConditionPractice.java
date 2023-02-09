package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPractice {
	
	public void practice1(){
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 한 개 입력 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			if(num % 2 == 0) {
				System.out.println("짝수입니다.");
			}else {
				System.out.println("홀수입니다.");
			}
		}else {
			System.out.println("양수만 입력해주세요.");
		}
	}
	
	public void practice2(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어점수 : ");
		int num1 = sc.nextInt();
		
		System.out.println("수학점수 : ");
		int num2 = sc.nextInt();
		
		System.out.println("영어점수 : ");
		int num3 = sc.nextInt();
		
		int sum = num1 + num2 + num3;
		double average = sum/3.0;
		
		if(num1 >= 40 && num2 >= 40 && num3 >= 40) {
			if(average >= 60) {
				System.out.println("국어 : " + num1);
				System.out.println("수학 : " + num2);
				System.out.println("영어 : " + num3);
				System.out.println("합계 : " + sum);
				System.out.println("평균 : " + average);
				System.out.println("축하합니다, 합격입니다!");
			}else {
				System.out.println("불합격입니다.");
			}
		}else {
			System.out.println("불합격입니다.");
		}
	}
	
	public void practice3(){
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12 : System.out.println(month + "월은 31일까지 있습니다."); break;
		case 2, 4, 6, 9, 11 : System.out.println(month + "월은 30일까지 있습니다."); break;
		default : System.out.println(month + "월은 잘못 입력된 달입니다.");
		}
		
	}
	
	public void practice4(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double kg = sc.nextDouble();
		
		double bmi = kg/(height*height);
		
		if(bmi >= 30) {
			System.out.println("BMI 지수 : " + bmi + "\n고도 비만");
		}else if(bmi >= 25 && bmi <30) {
			System.out.println("BMI 지수 : " + bmi + "\n비만");
		}else if(bmi >= 23 && bmi <25) {
			System.out.println("BMI 지수 : " + bmi + "\n과체중");
		}else if(bmi >= 18.5 && bmi <23) {
			System.out.println("BMI 지수 : " + bmi + "\n정상체중");
		}else {
			System.out.println("BMI 지수 : " + bmi + "\n저체중");
		}
	}
	public void practice5(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		int num1 = sc.nextInt();
		System.out.print("기말 고사 점수 : ");
		int num2 = sc.nextInt();
		System.out.print("과제 점수 : ");
		int num3 = sc.nextInt();
		System.out.print("출석 점수 : ");
		int num4 = sc.nextInt();
		
		if(num4 < 14) { // 출석 30이상 fail
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
