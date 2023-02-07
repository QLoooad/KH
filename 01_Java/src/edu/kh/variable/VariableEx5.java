package edu.kh.variable;

public class VariableEx5 {

	public static void main(String[] args) {
		
		/* 형변환(Casting)
		 * 
		 * 왜?
		 * -> 컴퓨터의 값 처리 원칙을 위배하는 경우를 해결하기 위해 필요
		 * (같은 자료형끼리 연산, 결과도 같은 자료형)
		 * 
		 * [자동 형변환]
		 * -<값의 범위>가 서로 다른 두 값의 연산 시
		 * <컴파일러(번역기)>가 자동으로 <값의 범위> 가 작은 자료형을 큰 자료형으로 변환
		 * 
		 * [강제 형변환]
		 * 값 범위 큰 자료형을 작은 자료형으로 || 원하는 자료형으로  강제 변환
		 * 
		 * */
		
		int num1 = 10;
		long num2 = 100L;
		System.out.println("num1+num2 : "+(num1+num2));
		
		//char >> int 변환
		
		char ch = 'g';
		
		int num5 = ch;
		System.out.println(ch +" : " + num5);
		
		//강제 형변환
		int test1 = 290;
		byte test2 = (byte) test1;
		System.out.println(test2);
		//강제 형변환(버림)
		double test3 = -1.3;
		int test4 = (int)test3;
		System.out.println("test3 : " + test3);
		System.out.println("test4 : " + test4);
		//강제 형변환(값 범위 관계없이 변환)
		int test5 = 1;
		int test6 = 2;
		System.out.println(test5/test6);
		//자동 + 강제 형변환
		System.out.println((double)test5/test6);
		
		//데이터 오버플로우
		
		byte bNum = 126;
		System.out.println(bNum);
		
		bNum = (byte)(bNum + 1);
		System.out.println(bNum);
		bNum = (byte)(bNum + 1);
		System.out.println(bNum);
		
		int iNum1 = 1000000000;
		int iNum2 = 2000000000;
		
		int iNum3 = iNum1 + iNum2;
		System.out.println(iNum3);
	}

}
