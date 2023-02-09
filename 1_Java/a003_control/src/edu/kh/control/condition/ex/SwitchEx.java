package edu.kh.control.condition.ex;

import java.util.Scanner;

public class SwitchEx {

	/*	switch문 (switch - case문)
	 * 
	 * 	-식 하나의 결과로 많은 경우의 수를 처리할 때 사용하는 조건문
	 * 		-> 식의 결과에 맞는 case문이 수행됨
	 * 
	 * 	[작성법]
	 *	switch( 식 ){ 식 수행 결과 = true/false가 아닌 정수, 문자열
	 *	
	 *	case 결과값 1 : 수행코드 1; break;
	 *	case 결과값 2 : 수행코드 2; break;
	 *	case 결과값 3 : 수행코드 3; break;
	 *	default : 모든 case가 만족하지 않을 경우 수행
	 *	}
	 * */

	public void ex1() {
//		키보드로 정수 입력
//		1 = RED
//		2 = ORANGE
//		3 = YELLOW
//		4 = GREEN
//		else = BLUE
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		String result;
		
//		if(input < 1 || input > 4) {
//			result = "BLUE";
//		}else if(input == 1) {
//			result = "RED";
//		}else if(input == 2) {
//			result = "ORANGE";
//		}else if(input == 3) {
//			result = "YELLOW";
//		}else {
//			result = "GREEN";
//		}
		
		switch(input) {
		case 1 : result = "RED"; break;
		case 2 : result = "ORANGE"; break;
		case 3 : result = "YELLOW"; break;
		case 4 : result = "GREEN"; break;
		default : result = "BLUE";
		}
		
		System.out.println(result);
	}
	
	public void ex2() {
		
//		랜덤 팀 배정
//		백0, 청1, 홍2
		
		int random = (int)(Math.random()*3);
		System.out.println(random);
		String result;
		
		switch(random) {
		case 0 : result = "백팀"; break;
		case 1 : result = "청팀"; break;
		default : result = "홍팀";
		}
		System.out.println(result);
	}
	
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		//메뉴 입력 후 가격 출력
		
		System.out.println("메뉴를 입력하세요 : (김밥/라면/샌드위치/떡볶이)");
		
		String input = sc.next();
		
		int price;
		
		switch(input) {
		case "김밥" : price = 3000; break;
		case "라면" : price = 4500; break;
		case "샌드위치" : price = 5800; break;
		case "떡볶이" : price = 3000; break;
		default : price = -1;
		}
		
		if(price != -1) {
			System.out.printf("%s은(는) %d원 입니다.", input, price);
		}else {
			System.out.println("존재하지 않는 메뉴입니다.");
		}
		
	}
	
	public void ex4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수1 입력 : ");
		int int1 = sc.nextInt();
		
		System.out.print("연산자 입력 : ");
		String arith = sc.next();
		
		System.out.print("정수2 입력 : ");
		int int2 = sc.nextInt();
		
		/*switch(arith) {
		case "+" : System.out.printf("%d + %d = %d", int1, int2, int1+int2); break;
		case "-" : System.out.printf("%d - %d = %d", int1, int2, int1-int2); break;
		case "*" : System.out.printf("%d * %d = %d", int1, int2, int1*int2); break;
		case "/" : if(int2 == 0) {
						System.out.println("0으로는 나눌 수 없습니다.");
					}else{
						System.out.printf("%d / %d = %.2f", int1, int2, (double)int1/int2);
					}; break;
		case "%" : if(int2 == 0) {
						System.out.println("0으로는 나눌 수 없습니다.");
					}else{
						System.out.printf("%d / %d = %d", int1, int2, int1%int2);
					}; break;
		default : System.out.println("존재하지 않는 연산자 입니다.");
		}*/
		
		int result1 = 0;
		
		int err = 0; // int2 == 0 일때 1, 연산자 오류일때 2
		
		if(arith.equals("+")) {
			result1 = int1 + int2;
			
		}else if(arith.equals("-")) {
			result1 = int1 - int2;
			
		}else if(arith.equals("*")) {
			result1 = int1 * int2;
			
		}else if(arith.equals("/")) {
			if(int2 == 0) {
				err = 1; //"0으로는 나눌 수 없습니다."
			}
		}else if(arith.equals("%")) {
			if(int2 == 0) {
				err = 1;//"0으로는 나눌 수 없습니다."
			}else {
				result1 = int1 / int2;
			}
		}else {
			err = 2; //"존재하지 않는 연산자 입니다."
		}
		
		if(err == 1 || err == 2) {
			if(err == 1) {
				System.out.println("0으로는 나눌 수 없습니다.");
			}else if(err == 2){
				System.out.println("존재하지 않는 연산자 입니다.");
			}
		}else if(arith.equals("+") || arith.equals("-") || arith.equals("*") ||arith.equals("%")) {
			System.out.println("\n" + int1 + " " + arith + " " + int2 + " = " + result1);
		}else {
			System.out.printf("%d / %d = %.2f", int1, int2, (double)int1/int2);
		}
		
		
	}
}
