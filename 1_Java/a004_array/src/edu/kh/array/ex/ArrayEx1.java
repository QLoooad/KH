package edu.kh.array.ex;

import java.util.Scanner;

public class ArrayEx1 {
	/* 배열
	 * 같은 자료형의 변수를 하나의 묶음으로 다루는 것
	 * 묶여진 변수들은 하나의 이름으로 불러지고
	 * 각각의 변수는 index(0~)를 이용해서 구분
	 * */
	public void ex1() {
		// 기본자료형 8개를 제외한 나머지느 "참조형" 이라고한다
		int[] array = new int[4];
		
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		System.out.println(array[0] + "\n--------------------------");
		int sum = 0;
		for(int i = 0; i< array.length; i++) {
			System.out.println(array[i]);
			sum += array[i];
		}
		System.out.println(sum);
		System.out.println(array);
		
		
	}
	public void ex2() {
		int[] array = new int[4];
		array[0] = 100;
		array[1] = 5;
		array[2] = 300;
		array[3] = 99;
		//breakpoint : 디버그 모드로 실행 시 해당 줄의 코드 
		System.out.println("---------------");
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i * 10 + 1;
		}
		System.out.println("----------------------");
		
		//선언과 동시에 초기화
		
		int[] array1 = {100, 200, 300, 400, 500};
		
		System.out.println("----------------------");
		
	}
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		double[] array = new double[3]; // 170.5, 165.7, 180.4 /3 = 172.2
		double sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			System.out.printf("%d번 키 입력 : ", i + 1);
			array[i] = sc.nextDouble();
		}
		
		System.out.print("입력 받은 키 : ");
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
			sum += array[i];
		}
		
		double agv = sum / 3;
		System.out.printf("\n평균 키 : %.1fcm", agv);
	}
	public void ex4() {
		
		String[] menuArr = {"김밥 + 라면", "서브웨이", "KFC", "맘스터치", 
				"순대국", "뼈해장국", "닭갈비", "마라탕", "우육면", "파스타", "샐러드"};
		
		int index = (int)(Math.random() * menuArr.length);
		System.out.println("오늘의 점심 메뉴 : " + menuArr[index]);
	}
	public void ex5() {
		int[] arr = {10,30,50,70,90};
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(arr[6]);
//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 5
//이유 : (for문의 조건식에서 i의 범위가 ) 배열의 인덱스 범위를 초과하는 값까지 증가하도록 작성되었기때문
		
		//해결방법 조건식을 i < arr.length; 로 수정
	}
}
