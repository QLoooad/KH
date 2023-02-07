package edu.kh.variable;

public class VariableEx3 {

	public static void main(String[] args) {
		
		//상수 명명 규칙 및 활용법
		// 모두 대문자, 단어 구분 시 _ 사용
		final int CONSTANT_NUMBER = 1;
		final double PI = 3.14;
		double result = PI * 10 * 10;
		System.out.println(result);
		
		final int UP = 5;
		final int DOWN = -5;
		final int INIT = 0;
		
		int result2 = INIT;
		System.out.println(result2);
		
		result2 = result2+UP;
		System.out.println(result2);
		
		result2 = result2+DOWN+DOWN;
		System.out.println(result2);
		
		//       변수 명명 규칙
		
		//대소문자 구분, 길이제한x
		//예약어 사용 금지 (int char final ....)
		//숫자 시작 금지
		//특수문자 _ $ 만 사용 가능
		//파스칼 표기법 (PascalCase)과 *카멜 표기법*(camelCase)를 사용
		//반의어는 반드시 대응하는 개념으로 사용
	}

}
