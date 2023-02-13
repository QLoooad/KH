package edu.kh.control.branch.ex;

import java.util.Scanner;

public class BranchEx {
	
	//분기문
	//break (가장 가까운 반복문 종료)
	//continue (가장 가까운 반복문 처음으로 돌아감)
	
	public void ex1() {
		
		for(int i = 0; i < 10000; i++) {
			System.out.println(i);
			if(i == 20) {
				break;
			}
		}
	}
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		while(true) {
			int num = sc.nextInt();
			sum += num;
			if(num == 0) {
				break;
			}
		}
		System.out.println("합계 : " + sum);
	}
	public void ex3() {
		for(int i = 0; i <=5; i++) {
			for(int j = 0; j <=5; j++) {
				System.out.printf("(%d,%d) ",i,j);
				if(j == 3)break;
			}
			System.out.println();
		}
	}
	public void ex4() {
		for(int i = 0; i <=10; i++) {
			if(i % 2 ==0)continue;
		}
	}
	public void ex5() {
		for(int i = 1; i <=100; i++) {
			if(i == 40)break;
			if(i % 5 == 0)continue;
			System.out.println(i);
		}
	}
	public void upDownGame() {
		/*	1~50 난수 지정
		 * 	사용자 시도횟수 count
		 * 	틀렷을 경우 난수가 더 크면 up, 작으면 down
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		int randomNum = (int)(Math.random()* 50 + 1);
		int count = 0;
		System.out.println("정수를 입력해주세요.");
		
		while(true) {
			System.out.println(count + "번 입력");
			int input = sc.nextInt();
			if(input == randomNum) {
				System.out.println("맞췄습니다.\n총 입력 횟수 : " + count + "회");
				break;
			}else if(input > randomNum) {
				System.out.println("Down");
			}else {
				System.out.println("Up");
			}
			count++;
		}
	}
	public void ex6() {
		/*	시작번호 부터 끝까지 1씩 증가 출력
		 * 특정 수 배수 입력받아 출력 모양변경
		 * 시작5
		 * 종료13
		 * 변경배수6
		 * 5 [6] 7 8 9 10 11[12]
		 * */
		Scanner sc = new Scanner(System.in);
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		int multi = sc.nextInt();
		
		for(int i = start; i <= end; i++) {
			if(i <= end) {
				if(i % multi == 0) {
					System.out.print("["+i+"] ");
				}else {
					System.out.print(i + " ");
				}
			}
		}
	}
}
