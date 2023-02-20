package edu.kh.array.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

	public void practice1() {//
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			if (i % 2 == 0) {
				sum += arr[i];
			}
		}
		System.out.println(sum);
//		System.out.println(Arrays.toString(arr));
	}

	public void practice2() {//
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - i;
			if (i % 2 != 0) {
				sum += arr[i];
			}
		}
		System.out.println(sum);
//		System.out.println(Arrays.toString(arr));
	}

	public void practice3() {//
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
//		System.out.println(Arrays.toString(arr));
	}

	public void practice4() {//
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];

		int index = -1;

		for (int i = 0; i < 5; i++) {
			System.out.print("입력 " + i + " : ");
			arr[i] = sc.nextInt();
		}
		System.out.print("검색할 값 : ");
		int find = sc.nextInt();

		for (int i = 0; i < arr.length; i++) {
			if (find == arr[i]) {
				index = i;
			}
		}
		if (index < 0) {
			System.out.println("존재하지 않습니다.");
		} else {
			System.out.println(index);
		}
	}

	public void practice5() {//
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 : ");
		String str = sc.next();
		System.out.print("문자 : ");
		char find = sc.next().charAt(0);

		char[] charArr = str.toCharArray();
		int count = 0;
		System.out.printf(str + "에 " + find + "가 존재하는 위치(인덱스) : ");

		for (int i = 0; i < charArr.length; i++) {
			if (find == charArr[i]) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.printf("\n%c 개수 : %d", find, count);
	}

	public void practice6() {//
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("총 합 : " + sum);
	}

	public void practice7() {//
		Scanner sc = new Scanner(System.in);

		System.out.print("주민등록번호(-포함) : ");
		String str = sc.next();
		char[] charArr = str.toCharArray();

		for (int i = 0; i < charArr.length; i++) {
			if (i > 7) {
				System.out.print("*");
			} else {
				System.out.print(charArr[i]);
			}
		}
	}

	public void practice8() {//
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("정수 : ");
			int input = sc.nextInt();
			if (input > 3 && input % 2 == 1) {
				int half = (input / 2) + (input % 2);
				int[] array = new int[input];
				for (int i = 1; i <= half; i++) {
					System.out.print(i + " ");
				}
				for (int j = half - 1; j > 0; j--) {
					System.out.print(j + " ");
				}
				break;
			} else {
				System.out.println("다시 입력하세요.");
			}
		}
	}

	public void practice9() {//
		int[] array = new int[10];
		System.out.print("발생한 난수 : ");
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10 + 1);
			System.out.print(array[i] + " ");
		}
	}

	public void practice10() {//
		int[] array = new int[10];
		int max = array[0];
		int min = 11;
		System.out.print("발생한 난수 : ");
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10 + 1);
			System.out.print(array[i] + " ");
			if (max < array[i]) {
				max = array[i];
			}
			if (min > array[i]) {
				min = array[i];
			}
		}
		System.out.println("\n최대값 : " + max);
		System.out.println("최소값 : " + min);
	}

	public void practice11() {//
		int[] array = new int[10];
		System.out.print("발생한 난수 : ");
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10 + 1);
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					i--;
				}
			}
		}
		for (int copyArr : array) {
			System.out.print(copyArr + " ");
		}
	}

	public void practice12() {//
		int[] array = new int[6];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					i--;
				}
			}
		}
		Arrays.sort(array);
		for (int copyArr : array) {
			System.out.print(copyArr + " ");
		}
	}

	public void practice13() {//
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String result = "";
		int count = 0;
		System.out.print("문자열에 있는 문자 : ");
		for (int i = 0; i < str.length(); i++) {
			if (str.indexOf(str.charAt(i)) == i) {
				result += str.charAt(i) + ", ";
				count++;
			}
		}
		result = result.replaceAll(", $", "");
		System.out.println(result);
		System.out.println("문자 개수 : " + count);

	}

	public void practice14() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		int arrSize = sc.nextInt();
		int arrSize2;
		String[] strArr = new String[arrSize];
		
		int strCount = 1;
		
		for(int i = 0; i < strArr.length; i++) {
			System.out.print(strCount + "번째 문자열 : ");
			strArr[i] = sc.next();
			strCount++;
		}
		
		String[] totalArray;
		
		System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
		String yesOrNo = sc.next();
		
		while(yesOrNo.equals("y")) {
			
			System.out.print("더 입력하고 싶은 개수 : ");
			arrSize2 = sc.nextInt();
			
			
			arrSize = arrSize+arrSize2;
			totalArray = new String[arrSize];
			
			System.arraycopy(strArr, 0, totalArray, 0, strArr.length);
			
			for(int i = strArr.length; i < totalArray.length; i++) {  
	              System.out.print(strCount + "번째 문자열 : ");
	              totalArray[i] = sc.next();
	              strCount++;
	           }
			
			strArr = totalArray.clone();
			
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			yesOrNo = sc.next();
		}
		System.out.println(Arrays.toString(strArr));
		
	}

	public void practice15() {//
		int[][] arr = new int[3][3];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("(%d, %d)", i, j);
			}
			System.out.println();
		}
	}

	public void practice16() {//
		int[][] arr = new int[4][4];
		int count = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%2d ", count);
				count++;
			}
			System.out.println();
		}
	}

	public void practice17() {//
		int[][] arr = new int[4][4];
		int count = 16;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%2d ", count);
				count--;
			}
			System.out.println();
		}
	}

	public void practice18() {//
		int[][] arr = new int[4][4];
		int totalSum = 0;
		int[] rowSumArr = new int[3];
		int[] colSumArr = new int[3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = (int) (Math.random() * 10 + 1);
				rowSumArr[i] += arr[i][j];
				totalSum += arr[i][j];
				System.out.printf("%3d",arr[i][j]);
			}
			System.out.printf("%3d ",rowSumArr[i]);
			System.out.println();
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				colSumArr[i] += arr[j][i];
			}
			System.out.printf("%3d",colSumArr[i]);
		}
		//행 열 한꺼번에는 왜 안되는가
		System.out.println(" " + totalSum);
		System.out.println();
	}

	public void practice19() {//
		Scanner sc = new Scanner(System.in);
		System.out.print("행 크기 : ");
		int row = sc.nextInt();
		System.out.print("열 크기 : ");
		int col = sc.nextInt();
		char[][] array = new char[row][col];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (char) ((Math.random() * 26) + 65);
				System.out.printf("%c ", array[i][j]);
			}
			System.out.println();
		}
	}

	public void practice20() {//
		Scanner sc = new Scanner(System.in);
		System.out.print("행 크기 : ");
		int row = sc.nextInt();
		char[][] array = new char[row][];
		char alphabet = 'a';

		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d열의 크기 : ", i);
			array[i] = new char[sc.nextInt()];
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = alphabet;
				alphabet++;
				System.out.printf("%c ", array[i][j]);
			}
			System.out.println();
		}
	}

	public void practice21() {//
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		int studentsLengthCount1 = 0;
		int studentsLengthCount2 = 6;
		
		String[][] fDivision = new String[3][2];
		String[][] sDivision = new String[3][2];
		
		for(int i = 0; i < fDivision.length; i++) {
				for(int j = 0; j < fDivision[i].length; j++) {
					fDivision[i][j] = students[studentsLengthCount1];
					studentsLengthCount1++;
				}
				for(int j = 0; j < fDivision[i].length; j++) {
					sDivision[i][j] = students[studentsLengthCount2];
					studentsLengthCount2++;
				}
			}
		System.out.println("== 1분단 ==");
		for(int i = 0; i < fDivision.length; i++) {
			for(int j = 0; j < fDivision[i].length; j++) {
				System.out.printf(fDivision[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2분단 ==");
		for(int i = 0; i < sDivision.length; i++) {
			for(int j = 0; j < sDivision[i].length; j++) {
				System.out.printf(sDivision[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void practice22() {//
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		int studentsLengthCount1 = 0;
		int studentsLengthCount2 = 6;
		
		String[][] fDivision = new String[3][2];
		String[][] sDivision = new String[3][2];
		
		for(int i = 0; i < fDivision.length; i++) {
				for(int j = 0; j < fDivision[i].length; j++) {
					fDivision[i][j] = students[studentsLengthCount1];
					studentsLengthCount1++;
				}
				for(int j = 0; j < fDivision[i].length; j++) {
					sDivision[i][j] = students[studentsLengthCount2];
					studentsLengthCount2++;
				}
			}
		System.out.println("== 1분단 ==");
		for(int i = 0; i < fDivision.length; i++) {
			for(int j = 0; j < fDivision[i].length; j++) {
				System.out.printf(fDivision[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2분단 ==");
		for(int i = 0; i < sDivision.length; i++) {
			for(int j = 0; j < sDivision[i].length; j++) {
				System.out.printf(sDivision[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("============================");
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 학생 이름을 입력하세요. : ");
		String findName = sc.next();
		
		for(int i = 0; i < fDivision.length; i++) {
			for(int j = 0; j < fDivision[i].length; j++) {
				String fDivName = fDivision[i][j];
				if(fDivName.equals(findName)) {
					if(j % 2 == 0) {
						System.out.printf("\n검색하신 %s 학생은 "
								+ "1분단 %d번째 줄 왼쪽에 있습니다.", findName, i+1);
					}
					if(j % 2 == 1) {
						System.out.printf("\n검색하신 %s 학생은 "
								+ "1분단 %d번째 줄 오른쪽에 있습니다.", findName, i+1);
					}
				}
			}
		}
		for(int i = 0; i < sDivision.length; i++) {
			for(int j = 0; j < sDivision[i].length; j++) {
				String sDivName = sDivision[i][j];
				if(sDivName.equals(findName)) {
					if(j % 2 == 0) {
						System.out.printf("\n검색하신 %s 학생은 "
								+ "2분단 %d번째 줄 왼쪽에 있습니다.", findName, i+1);
					}
					if(j % 2 == 1) {
						System.out.printf("\n검색하신 %s 학생은 "
								+ "2분단 %d번째 줄 오른쪽에 있습니다.", findName, i+1);
					}
				}
			}
		}
	}

	public void practice23() {//
		String[][] array = new String[6][6];
		Scanner sc = new Scanner(System.in);
		System.out.print("행 인덱스 입력 : ");
		int row = sc.nextInt();
		System.out.print("열 인덱스 입력 : ");
		int col = sc.nextInt();
		for (int i = 0; i < array.length; i++) { // " ", 0, 1, 2, 3, 4 row col입력
			for (int j = 0; j < array[i].length; j++) { //공백 만들기
				if(i == row+1 && j == col+1) {
					array[i][j] = "X";
				}else {
					array[i][j] = " ";
				}
			}
			if(i == 0) {//행 인덱스
				for (int j = 0; j < array.length; j++) {
					array[i][j] = Integer.toString(j-1);
				}
			}
			if(i > 0 || i <=5 ) {// 열 인덱스
				for (int j = 0; j < 1; j++) {
					array[i][j] = Integer.toString(i-1);
				}
			}
		}
		array[0][0] = " "; // 0.0 == " "
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void practice24() {//
		String[][] array = new String[6][6];
		Scanner sc = new Scanner(System.in);
		
		int row = 0;
		//기본 틀
		for (int i = 0; i < array.length; i++) { // " ", 0, 1, 2, 3, 4 row col입력
			for (int j = 0; j < array[i].length; j++) { //공백입력
				array[i][j] = " ";
			}
			if(i == 0) {//행 인덱스
				for (int j = 0; j < array.length; j++) {
					array[i][j] = Integer.toString(j-1);
				}
			}
			if(i > 0 || i <=5 ) {// 열 인덱스
				for (int j = 0; j < 1; j++) {
					array[i][j] = Integer.toString(i-1);
				}
			}
		}
		array[0][0] = " "; // 0.0 == " "
		while(row != 99) {
			
			System.out.print("행 인덱스 입력 : ");
			row = sc.nextInt();
			if(row == 99) {
				System.out.println("프로그램 종료");
				break;
			}
			System.out.print("열 인덱스 입력 : ");
			int col = sc.nextInt();
			
			for (int i = 0; i < array.length; i++) { 
				for (int j = 0; j < array[i].length; j++) { // "X" 입력
					if(i == row+1 && j == col+1) {
						array[i][j] = "X";
					}
				}
			}
			
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					System.out.print(array[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	public void bingoGame() {
		String star = String.valueOf((char)9733);
		Scanner sc = new Scanner(System.in);
		System.out.print("빙고판 크기 지정 : ");
		int bingoSize = sc.nextInt();
		if(bingoSize <= 0) {
			System.out.println("잘못 입력하셧습니다.\n빙고를 종료합니다.");
			System.exit(0);
		}
		
		String[] array1 = new String[bingoSize*bingoSize];//중복제거용
		String[][] array2 = new String[bingoSize][bingoSize];
		
		int duplicateCount = 0;
		
		for (int i = 0; i < array1.length; i++) { //bingoSize*bingoSize 중복 없는 난수 생성
			array1[i] = Integer.toString((int)((Math.random() * (bingoSize*bingoSize)) + 1));
			for (int j = 0; j < i; j++) {
				if (array1[i].equals(array1[j])) {
					i--;
				}
			}
		}
		for (int i = 0; i < array2.length; i++) {// 난수 기입 && 빙고 출력
			for (int j = 0; j < array2[i].length; j++) {
				array2[i][j] = array1[duplicateCount];
				duplicateCount++;
				System.out.printf("%3s ",array2[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("========================= 빙고게임 시작 =========================");
		while(true) {
			System.out.print("정수를 입력하시오 : ");
			String bingoNum = sc.next();
			
			if(Integer.parseInt(bingoNum) > bingoSize*bingoSize || Integer.parseInt(bingoNum) < 1) {
				System.out.println("\"다시 입력해주세요.\"");
			}else {
				
				int bingoCount = 0;
				int DiagonalLeftStarCount = 0;
				int DiagonalRightStarCount = 0;
				
				for (int i = 0; i < array2.length; i++) {// 별과 숫자 비교 후 변환
					for (int j = 0; j < array2[i].length; j++) {
						if(bingoNum.equals(array2[i][j])) {
							array2[i][j] = star;
						}
					}
				}
				for (int i = 0; i < array2.length; i++) {// 별 출력
					for (int j = 0; j < array2[i].length; j++) {
						System.out.printf("%3s ",array2[i][j]);
					}
					System.out.println();
				}
				
				for (int i = 0; i < array2.length; i++) {//빙고 판별
					int rowStarCount = 0;
					int colStarCount = 0;
					

					for (int j = 0; j < array2[i].length; j++) {//row 빙고
						if(array2[i][j].equals(star)) {
							rowStarCount++;
							if(rowStarCount==bingoSize) {
								bingoCount++;
								rowStarCount = 0;
							}
						}
					}
					for (int j = 0; j < array2[i].length; j++) {//col 빙고
						if(array2[j][i].equals(star)) {
							colStarCount++;
							if(colStarCount==bingoSize) {
								bingoCount++;
								colStarCount = 0;
							}
						}
					}
					
					if(array2[i][i].equals(star)) {//왼 대각 시작 빙고
						DiagonalLeftStarCount++;
					}if(DiagonalLeftStarCount==bingoSize) {
						bingoCount++;
					}
					
					for (int j = 0; j < array2[i].length; j++) {//오른 대각 시작 빙고
						if((i + j + 1) == bingoSize) {
							if(array2[i][j].equals(star)) {
								DiagonalRightStarCount++;
							}
						}if(DiagonalRightStarCount==bingoSize) {
							bingoCount++;
							DiagonalRightStarCount = 0;
						}
					}
					
				}
				System.out.println("현재 " + bingoCount + "빙고");
				if(bingoCount >= 3) { 
					System.out.println("************************************************");
					System.out.println("*************** ! ! ! BINGO ! ! !***************");
					System.out.println("************************************************");
					break;
				}
			}
				
			}
			
	}
}
