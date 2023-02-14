package edu.kh.array.ex;

import java.util.Random;

public class ArrayEx2 {

	// 2차원 배열

	public void ex1() {

		int[][] arr = new int[2][3];

		System.out.println(arr.length);
		System.out.println(arr[0].length);

		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num * 5;
				num++;
			}
		}
	}
	public void ex2() {
		/*	3행 3열 짜리 2차원 배열에 0-9난수 대입
		 * 	각 행 합, 전체 합 출력
		 * 	3 2 5
		 * 	9 7 2
		 *  1 2 3
		 *  
		 *  0 행의 합 : 10
		 *  1 행의 합 : 18
		 *  2 행의 합 : 6
		 *  전체 합 : 34
		 * */
		
		int[][] arr = new int[3][3];
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			int rowSum = 0;
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int)(Math.random()*10);
				rowSum += arr[i][j];
				sum += arr[i][j];
			}
			System.out.printf("%d 행의 합 : %d\n", i, rowSum);
		}
		System.out.println("전체 합 : " + sum);
	}
	public void ex3() { //가변 배열
		
		char[][] arr = new char [4][];
		arr[0] = new char[3];
		arr[1] = new char[4];
		arr[2] = new char[5];
		arr[3] = new char[2];
		char alphabet = 'A';
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = alphabet;
				alphabet++;
				System.out.printf("%2c", arr[i][j]);
			}
			System.out.println();
		}
		
	}
}
