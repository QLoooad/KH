package edu.kh.array.ex;

import java.util.Arrays;
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
	public void ex6() {
		
		/*	인원수 입력, 그 크기만큼 정수 배열 선언 및 할당
		 * 각 배열 요소에 점수 입력 저장
		 * 입력 후 합,평균, 최고-저 출력
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 받을 인원 수 : ");
		int size = sc.nextInt();
		int[] score = new int[size];
		int sum = 0;
		
		for(int i = 0; i < score.length; i++) {
			System.out.print((i+1) + "번 점수 입력 : ");
			score[i] = sc.nextInt();
			sum += score[i];
		}
		double agv = (sum/(double)size);
		/*
		Arrays.sort(score);
		
		int high = score[size-1];
		int low = score[0];
		*/
		
		int max = score[0];
		int min = score[0];
		int maxIndex = 0;
		int minIndex = 0;
		for(int i = 0; i < score.length; i++) {
			if(max<score[i]) {
				max = score[i];
				maxIndex = i;
			    }
		    if(min>score[i]) {
		    	min = score[i];
		    	minIndex = i;
		    }
		}
		
		System.out.println("평균 점수 : " + agv);
		System.out.printf("최고 점수 : %d (%d번 학생)\n", max, maxIndex+1);
		System.out.printf("최저 점수 : %d (%d번 학생)\n", min, minIndex+1);
	}
	public void ex7() {
		/*	입력 받은 정수가 배열에 존재 시 해당 인덱스 출력
		 *	없으면 "존재하지 않습니다"
		 * */
		
		int[] arr = {100,200,300,400,500,600,700,800,900,1000};
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		/*
		int index = -1;
		
		for(int i = 0; i < arr.length; i++) {
			if(input == arr[i]) {
				index = i;
			}
		}
		if(index < 0) {
			System.out.println("존재하지 않습니다.");
		}else {
			System.out.println(index);
		}*/
		
		//flag 변수 이용
		
		int index = 0;
		boolean flag = true;
		//for문 종료 후 true : 검색 결과 존재 false: 미존재
		for(int i = 0; i < arr.length; i++) {
			if(input == arr[i]) {
				index = i;
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println("존재하지 않습니다.");
		}else {
			System.out.println(index);
		}
	}
	public void ex8() {
		/*	얕은 복사 
		 * 	참조 하는 배열/객체의 주소만을 복사   ex) pc의 바로가기
		 * 	서로 다른 참고 변수가 하나의 배열 객체를 참조함.(주소값만 공유)
		 * 
		 * 	깊은 복사
		 * 	원본과 같은 자료형, 크기는 같거나 더 큰 배열을 만들어
		 * 	원본의 데이터를 모두 복사하는 방법 a.clone
		 * */
		
		//얕은 복사
		int[] arr1 = {10,20,30,40,50};
		int[] copyArr1 = arr1;
		
		System.out.println("arr1  " + arr1);
		System.out.println("copyArr1  " + copyArr1);
		
		copyArr1[0] = 9999;
		System.out.println("arr1  " + Arrays.toString(arr1));
		System.out.println("copyArr1  " + Arrays.toString(copyArr1));
		System.out.println("--------------------------------");
		
		//깊은 복사
		int[] arr2 = {5,6,7,8};
		int[] copyArr2 = new int[arr2.length];
		
		
		
		/*for(int i = 0; i < arr2.length; i++) {
			copyArr2[i] = arr2[i];
		}*/
		//System.arraycopy(원본, 원본 시작 index, 복사명, 복사 시작 index, 복사길이);
		System.arraycopy(arr2, 0, copyArr2, 0, arr2.length);
		//copyArr2 = arr2.clone();
		
		System.out.println("arr2  " + arr2);
		System.out.println("copyArr2  " + copyArr2);
		
		copyArr2[0] = 9999;
		System.out.println("arr2  " + Arrays.toString(arr2));
		System.out.println("copyArr2  " + Arrays.toString(copyArr2));
	}
}
