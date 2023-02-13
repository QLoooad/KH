package edu.kh.control.loop.ex;

import java.util.Scanner;

public class WhileEx {
	
	/*		while
	 *별도의 초기, 증감식 존재 x
	 *반복 조건만 존재
	 *반복회후 지정되어있지 않은 반복에 사용 
	 * */
	
	public void ex1() {
		//0 입력 시 멈추기
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		int input = -1;
		
		while(input != 0) {
			System.out.println("정수 입력 : ");
			input = sc.nextInt();
			
			sum += input;
			System.out.println("현재 합계 : " + sum);
		}
		
		System.out.println("최종 결과 : " + sum);
		
	}
	
	public void ex2() {
		
		/* 분식집
		 * 1. 떡볶이 5000
		 * 2. 김밥 3000
		 * 3. 라면 4000
		 * 9. 주문완료
		 * 
		 * 떡볶이 김밥을 주문하셧습니다.
		 * 총 가격은 8000원입니다.
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		String menu = "";
		
		int input = 0;
		
		while(input != 9) {
			
			System.out.println("----- 메뉴 -----");
			System.out.println("1. 떡볶이(5000원)");
			System.out.println("2. 김밥(3000원)");
			System.out.println("3. 라면(4000원)");
			System.out.println("9. 주문 완료");
			
			System.out.println("메뉴 선택 >> ");
			input = sc.nextInt();
			System.out.println();
			
			switch(input) {
			case 1 : 
				sum += 5000;
				menu += "떡볶이 ";
				break;
			case 2 : 
				sum += 3000;
				menu += "김밥 ";
				break;
			case 3 : 
				sum += 4000;
				menu += "라면 ";
				break;
			case 9 : break;
			default : System.out.println("잘못 입력 하셧습니다.");
			}
			
		}
		
		System.out.println(menu + "을(를) 주문하셧습니다.");
		System.out.println("총 가격은 " + sum + "원 입니다.");
	}
	public void ex3() {
		
		/*	do while
		 * 	최소 1회 실행 반복 보장
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int input = 0;
		
		do{
			System.out.println("정수 입력 : ");
			input = sc.nextInt();
			
			sum += input;
			System.out.println("현재 합계 : " + sum);
		} while(input != 0);
		
		System.out.println("최종 결과 : " + sum);
		
	}
	public void ex4() {
		int num = 1;
		while(num <= 10) {
			System.out.println(num);
			num++;
		}
		for(int i = 1; i <= 1; i++) {
			System.out.println(i);
		}
			
	}
}
