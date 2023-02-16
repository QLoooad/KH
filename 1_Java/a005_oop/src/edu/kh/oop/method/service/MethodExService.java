package edu.kh.oop.method.service;


//	기능 제공용 객체를 만들기 위한 클래스
//	>> 비즈니스 로직
public class MethodExService {
	
	//매개 변수 o, 반환 값x
	public void threeNumbersSumAndAverage(int a, int b, int c) {
		//세 숫자 합, 평균
		
		int sum = a + b + c;
		double avg = sum / 3.0;
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
	}
	
	//매개 변수 x, 반환 값0
	public int[] fiveRandomNumbers() {
		
		int[] arr = new int[5];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
		}
		return arr;
	}
	
	public String calculate(int num1, int num2, String op) {
		
		//매개 변수명을 일치시켜 이해도 향상
		//변수명이 같다고해서 같은 변수는 아니다(동명이인 개념)
		
		// +, -, *  : 문제 없음 
		// /, %		: 0으로 나눌 경우 오류 발생
		//	정상 계산 : "5 + 10 = 15"
		//	오류 발생 : "0으로 나눌 수 없습니다."
		String result = null;
		//String은 참조형 == 주소를 저장
		//null : 참조하는게 없다(== 주소를 저장하고 있지 않다)
		//numm == 비어있다(false)
		
		// ==, !=
		// 참조형을 비교할 때 값이 아닌 주소를 비교
		// > 대부분 같지 않다 로 판별됨
		
		// boolean A = a.equals(b);
		// a와 b가 참조하는 객체의 값 비교 (true, false)
		
		if(num2 == 0 && (op.equals("/") || op.equals("%"))) {
			result = "0으로 나눌 수 없습니다.";
			
			//코드 수행 중 return구문을 만나면 즉시 메소드 종료 후 호출한 곳으로 돌아감
			return result;
		}
		
		//String.format("패턴(%d)", 변수)
		//패턴 형태의 문자열을 반환
		switch(op) {
		case "+" : result = String.format("%d %s %d = %d", num1, op, num2, num1+num2); break;
		case "-" : result = String.format("%d %s %d = %d", num1, op, num2, num1-num2); break;
		case "*" : result = String.format("%d %s %d = %d", num1, op, num2, num1*num2); break;
		
		case "/" : result = String.format("%d %s %d = %d", num1, op, num2, num1/num2); break;
		case "%" : result = String.format("%d %s %d = %d", num1, op, num2, num1%num2); break;
		
		default : result = "연산 기호가 잘못 입력 되었습니다.";
		}
		
		return result;
	}

}
