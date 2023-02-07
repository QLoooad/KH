package edu.kh.variable;

public class VariableEx2 {

	public static void main(String[] args) {

		
//		System.out.println("확인"); 한줄 출력
		// 변수 : 메모리에 값을 저장하기 위한 공간
		
		// 변수 선언 : 메모리에 값을 저장할 공간을 생성(할당)
		
		// 자료형 : 변수의 종류 지정(크기, 형식별로 다름)
		
		// 기본 자료형 8가지
		/* 
		 * 논리형 : boolean true,false			(1byte)
		 * 
		 * 정수형 : byte						(1byte)
		 * 			short						(2byte)
		 * 			int		1,-1,0,				(4byte, 정수 기본형)
		 * 			long	2147483648L,0L,1L	(8byte)
		 * 
		 * 실수형 : float	3.14f, -0.1f, 0.0f	(4byte)
		 * 			double	3.14, -0.1, 0.0		(8byte, 실수 기본형)
		 * 
		 * 문자형 : char	'a', '가'			(2byte, 유니코드 UTF-16 )
		 * */
		
		//자료형	변수명
		boolean booleanData = true;
		//논리형 데이터(true/false) 저장
		//1byte 메모리(ram)에 할당
		
		int num1 = 123456789;
		//정수형 데이터 저장
		//4byte 메모리(ram)에 할당
		
		double num2 = 9.87654321;
		//실수형 데이터 저장
		//8byte 메모리(ram)에 할당
		
		char ch = 'A';
		//문자형 데이터 저장
		//2byte 메모리(ram)에 할당
		
		System.out.println(booleanData);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(ch);
		
	}

}
