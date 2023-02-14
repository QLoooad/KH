package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

	public void practice1() {
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

	public void practice2() {
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

	public void practice3() {
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

	public void practice4() {
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

	public void practice5() {
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

	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.print("배열 0번째 인덱스에 넣을 값 : ");
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("총 합 : " + sum);
	}

	public void practice7() {
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

	public void practice8() {
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

	public void practice9() {
		int[] array = new int[10];
		System.out.print("발생한 난수 : ");
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10 + 1);
			System.out.print(array[i] + " ");
		}
	}

	public void practice10() {
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

	public void practice11() {
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

	public void practice12() {
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

	public void practice13() {
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
		int arraySize1 = sc.nextInt();
		String[] array1 = new String[arraySize1];
		int count = 1;
		for (int i = 0; i < array1.length; i++) {
			System.out.print(count + "번째 문자열 : ");
			array1[i] = sc.next();
			count++;
		}
		int arraySize2;
		int totalArrayLength;
		String[] totalArray = null;
		System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
		char retry = sc.next().charAt(0);
		System.out.print("더 입력하고 싶은 개수 : ");
		System.out.print(count + "번째 문자열 : ");
		count++;
//		System.arraycopy(array1, 0, totalArray, 0, array1.length);
//		System.arraycopy(array2, 0, totalArray, array1.length, array2.length);
		//계속 값 추가하면 배열 만드는거 안되는데 예시까지는 할수있어도
		//배열이 아닌 앱엔드, 어레이리스트 로하면 몰라도
	}

	public void practice15() {
		int[][] arr = new int[3][3];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("(%d, %d)", i, j);
			}
			System.out.println();
		}
	}

	public void practice16() {
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

	public void practice17() {
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

	public void practice18() {
		int[][] arr = new int[4][4];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = (int)(Math.random() * 10 +1);
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		int rowSum = 0;
		int colSum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 3; j++) { //2열까지 더함
				rowSum += arr[i][j];
			}
			System.out.println("rowSum : " + rowSum);
		}
	}

	public void practice19() {

	}

	public void practice20() {

	}

	public void practice21() {

	}

	public void practice22() {

	}

	public void practice23() {

	}

	public void practice24() {

	}

}
