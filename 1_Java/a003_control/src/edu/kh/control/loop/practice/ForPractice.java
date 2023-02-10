package edu.kh.control.loop.practice;

import java.util.Scanner;

public class ForPractice {

	public void practice1() {

		Scanner sc = new Scanner(System.in);
		System.out.println("1이상의 숫자를 입력하세요 : ");
		int num1 = sc.nextInt();
		if (num1 > 0) {
			for (int i = 1; i < num1 + 1; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}

	}

	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1이상의 숫자를 입력하세요 : ");
		int num1 = sc.nextInt();
		
		if (num1 > 0) {
			for (int i = num1; i > 0; i--) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}

	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i;
			if(i == num) {
				System.out.printf("%d = %d",i, sum);
			}else {
				System.out.printf("%d + ", i);
			}
		}
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.println("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		int min = (num1 < num2) ? num1 : num2; 
		int max = (num1 < num2) ? num2 : num1;;
		
		if(min < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}else {
			for(int i = min; i < max+1; i++) {
				System.out.print(i + " ");
			}
		}
	}

	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 : ");
		int num1 = sc.nextInt();
		System.out.println("===== " + num1 + "단 =====");
		for(int i = 1; i <= 9; i++) {
			System.out.println(num1 + " x " + i + " = " + num1*i);
		}
	}

	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 : ");
		int num = sc.nextInt();
		
		for(int i = num; i <= 9; i++) {
			System.out.printf("===== %d단 =====\n", i);
			for(int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i*j);
			}
		}
	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			for(int j = num; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void practice9() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();

		for(int i = 0; i < num; i++) {
			for(int j = 1; j < num-i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < i+1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 0; i < num-1; i++) {
			for(int j = num-1; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			for(int j = 1; j < num-i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < i*2+1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void practice12() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
		for(int i = 1; i <= num; i++) {
			if(i == 1 || i == num) {
				for(int j = 1; j <= num; j++) {
					System.out.print("*");
				}
			}else {
				for(int k = 1; k <= num; k++) {
					if(k == 1 || k == num) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
	public void practice13() {
		Scanner sc = new Scanner(System.in);
		System.out.println("자연수 하나를 입력하세요 : ");
		int num = sc.nextInt();
		int count = 0;
		for(int i = 1; i <= num; i++) {
			if(i % 2 == 0 ||i % 3 == 0) {
				System.out.print(i + " ");
			}
			if(i % 2 == 0 && i % 3 == 0) {
				count++;
			}
		}
		System.out.println("\ncount : "+ count);
	}
}
