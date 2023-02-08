package edu.kh.variable;

public class Practice {

	public static void main(String[] args) {

		/* 자동형변환
		 * 
		 * 
		 * [강제 형변환]
		 * 특정한 자료형으로 강제 변환(바꾸고 싶은 자료형을 명시)
		 * 테이터 손실 발생 가능
		 * 
		 * */
		
		int iNum1 = 10;
		int iNum2 = 4;
		float Fnum = 3.0f;
		double dNum = 2.5;
		char ch = 'A';
		System.out.println(iNum1/iNum2);
		System.out.println((int)ch); //65
		System.out.println(iNum1 + ch); //75
		System.out.println((char)(ch+10)); //K
		//sadfdfsaf
	}

}
