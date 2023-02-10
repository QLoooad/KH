package edu.kh.control.loop.ex;

import java.util.Scanner;

public class ForEx {
	/* 	for문
	 *  - 끝이 정해져있는경우에 사용하는 반복문
	 *  (== 반복횟수가 지정되어 있는 경우 사용)
	 * 
	 *  - 작성법
	 * for( 초기식; 조건식; 증감식){
	 * 		조건식 true일경우 반복할 코드
	 * }
	 * 
	 * - 초기식 : for문 제어용도 변수를 선언 및 초기화
	 * - 조건식 : for문의 반복 여부 지정
	 * 			  조건식이 true인 경우에만 반복 수행
	 * 			  보통 초기식에 사용된 변수 이용해 조건식 작성
	 * 
	 * */
	public void ex1(){
		//1~10출력
		for(int i = 1; i < 11; i++) {
			System.out.print(i + " ");
		}
	}
	public void ex2(){
		//1~10출력
		for(int i = 5; i < 13; i++) {
			System.out.print(i + " ");
		}
	}
	public void ex3(){
		//1~10출력
		for(int i = 3; i < 21; i+=2) {
			System.out.print(i + " ");
		}
	}
	public void ex4(){
		
		int sum = 0;
		for(int i = 1; i < 101; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	public void ex5(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("정수 2 입력 : ");
		int num2 = sc.nextInt();
		
		int sum = 0;
		
		for(int i = num1; i <= num2; i++) {
			sum += i;
		}
		System.out.printf("%d부터 %d까지 모든 정수의 합 : %d", num1, num2, sum);
		
	}
	public void ex6(){
		
		int sum = 0;
		for(double i = 10; i <= 50; i +=0.5) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i = 65; i <= 90; i++) {
			System.out.print((char)i + " ");
		}
		System.out.println();
		for(int i = 'A'; i <= 'Z'; i++) {
			System.out.print((char)i + " ");
		}
		System.out.println();
		for(char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i + " ");
		}
	}
	public void ex7(){
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
		}
	}
	public void ex8(){
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		for(int i = 1; i <= 5; i++) {
			System.out.printf("정수 입력 %d : ",i);
			sum += sc.nextInt();
		}
		System.out.println("합계 : " + sum);
	}
	public void ex9(){
		Scanner sc = new Scanner(System.in);
		System.out.println("입력받을 정수의 개수 : ");
		int inputN = sc.nextInt();
		
		int sum = 0;
		
		for(int i = 1; i <= inputN; i++) {
			System.out.printf("정수 입력 %d : ",i);
			sum += sc.nextInt();
		}
		System.out.println("합계 : " + sum);
	}
	public void ex10(){
		//1~10 짝수(i)
		
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				System.out.print("(" + i + ") ");
			}else {
				System.out.print(i + " ");
			}
		}
	}
	public void ex11(){
		//1~10 1++  3배수[i] 5배수 = @
		
		for(int i = 1; i <= 10; i++) {
			if(i % 3 == 0) {
				System.out.print("[" + i + "] ");
			}else if(i % 5 == 0){
				System.out.print("@ ");
			}else {
				System.out.print(i + " ");
			}
		}
	}
	public void ex12(){
		
		for(int i = 1; i <= 9; i++) {
			System.out.println("2 x " + i + " = " + 2*i);
		}
	}
	public void ex13(){
		Scanner sc = new Scanner(System.in);
		System.out.println("구구단 단수 : ");
		int num = sc.nextInt();
		
		for(int i = 9; i >= 1; i--) {
			System.out.println(num + " x " + i + " = " + num*i);
		}
	}
	public void ex14(){
		Scanner sc = new Scanner(System.in);
		System.out.println("구구단 단수 : ");
		int num = sc.nextInt();
		
		for(int i = 9; i >= 1; i--) {
			if(num < 2 || num > 9) {
				System.out.println("잘못된 입력");
				break;
			}else {
				System.out.println(num + " x " + i + " = " + num*i);
			}
		}
	}
	public void ex15(){
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	public void ex16(){
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.printf("%3d",i*j);
			}
			System.out.println();
		}
	}
	public void ex17(){
		for(int i = 2; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.printf(" [%d * %d = %d]", i, j, i*j);
			}
			System.out.println();
		}
	}
	public void ex18(){
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	public void ex19(){
		for(int i = 4; i >= 1; i--) {
			for(int j = 4; j >= i; j--) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	public void ex20(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i = num; i >= 1; i--) {
			for(int j = i; j >= 1; j--) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	public void ex21(){
		int count = 1;
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 4; j++) {
				System.out.printf("%3d",count);
				count++;
			}
			System.out.println();
		}
	}
}
