package edu.kh.control.condition.ex;

import java.util.Scanner;

public class ConditionEx {

	public void test1() {
		System.out.println("test1() 수행");
	}

	public void test2() {
		System.out.println("test2() 수행");
	}

	public void test3() {
		System.out.println("test3() 수행");
	}

	public void ex1() {// if

		Scanner sc = new Scanner(System.in);

		System.out.println("정수 입력 : ");
		int input = sc.nextInt();

		if (input > 0) {
			System.out.println("양수 입니다.");
			System.out.println("ex1() end");
		}

		if (input < 0) {
			System.out.println("음수 입니다.");
			System.out.println("ex1() 끝");
		}
	}

	public void ex2() { // if, else

		Scanner sc = new Scanner(System.in);

		System.out.println("정수 입력 : ");
		int input = sc.nextInt();

		if (input > 0) {
			System.out.println("양수 입니다.");
		} else {
			// System.out.println("음수 입니다.");
			if (input == 0) {
				System.out.println("0 입니다.");
			} else {
				System.out.println("음수 입니다.");
			}
		}
	}

	public void ex3() {// if, else if, else

		Scanner sc = new Scanner(System.in);

		System.out.println("정수 입력 : ");
		int input = sc.nextInt();
		if (input == 0) {
			System.out.println("0은 홀/짝수 구분이 불가합니다.");
		} else if (Math.abs(input) % 2 == 1) {
			System.out.println("홀수 입니다.");
		} else {
			System.out.println("짝수 입니다.");
		}
	}

	public void ex4() {

		Scanner sc = new Scanner(System.in);

		System.out.println("계절을 알고싶은 달(월) 입력 : ");
		int input = sc.nextInt();

		String result;

		if (input >= 3 && input <= 5) {
			result = "봄";

		} else if (input >= 6 && input <= 8) {
			result = "여름";

		} else if (input >= 9 && input <= 11) {
			result = "가을";

		} else if (input == 1 || input == 2 || input == 12) {
			result = "겨울";

		} else {
			result = "해당하는 계절이 없습니다.";
		}
		System.out.println(result);
	}

	public void ex5() { // 나이 입력, 13이하 어린이 13초과 19 이하 청소년 19초과 성인

		Scanner sc = new Scanner(System.in);

		System.out.println("나이 입력 : ");
		int input = sc.nextInt();

		String result;

		if (input <= 13) {
			result = "어린이";

		} else if (input <= 19) {
			result = "청소년";

		} else {
			result = "성인";

		}

		System.out.println(result);

	}

	public void ex6() {
		/*
		 * 놀이기구 제한 나이 > 12, 키 > 140 나이 < 12 : "적정 연령이 아닙니다." 키 < 140 : "적정 키가 아닙니다." 나이
		 * < 0 || 나이 > 100 : "잘못 입력 하셨습니다."
		 * 
		 * 출력 예시 나이 15, 키 170.5 : 탑승가능 나이 10, 키 150.5 : 적정 연령이 아닙니다. 나이 120, 키 183.3 :
		 * "잘못 입력 하셨습니다."
		 */

		Scanner sc = new Scanner(System.in);

		System.out.println("나이 입력 : ");
		int age = sc.nextInt();

		String result;
		
		System.out.println("키 입력 : ");
		double height = sc.nextDouble();

		if (age >= 12 && age <= 100) {
			if (height >= 140) {
				result = "탑승 가능";
			} else {
				result = "적정 키가 아닙니다.";
			}
		} else if (age < 12 && age >= 0) {
			result = "적정 연령이 아닙니다.";

		} else {
			result = "잘못 입력 하셨습니다.";

		}

		System.out.println(result);

	}

	public void ex7() {

		Scanner sc = new Scanner(System.in);

		System.out.println("나이 입력 : ");
		int age = sc.nextInt();

		String result;

		if (age < 0 || age > 100) {
			result = "잘못 입력 하셨습니다.";

		} else if (age < 12) {
			result = "적정 연령이 아닙니다.";

		} else { // 정상 입력 판단
			System.out.println("키 입력 : ");
			double height = sc.nextDouble();
			if(height < 100 || height > 220) {
				result = "잘못 입력 하셨습니다.";
			}else if(height < 140) {
				result = "적정 키가 아닙니다.";
			}else {
				result = "탑승 가능";
			}
		}
		System.out.println(result);
	}
}
