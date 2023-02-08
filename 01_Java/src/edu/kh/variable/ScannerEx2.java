package edu.kh.variable;

import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		
		System.out.print("이름 : ");
		String inputName = sc.next(); 
		
		System.out.print("나이 : ");
		int inputAge = sc.nextInt();
		
		System.out.print("키 : ");
		Double inputHeight = sc.nextDouble();
		
		System.out.printf("%s님은 %d세, 키 %.1f입니다.",inputName,inputAge,inputHeight);
	}

}
