package edu.kh.operator.ex;

import java.util.Scanner;

public class OperatorEx4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[홀짝 검사기]");
		
		System.out.println("정수를 입력해 주세요");
		
		int input = sc.nextInt();
		
		System.out.println(Math.abs(input) % 2 == 1 ?
				"홀수입니다." : input == 0 ? "0 입니다." : "짝수입니다.");
		
		
	}
}
