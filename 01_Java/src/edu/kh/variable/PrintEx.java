package edu.kh.variable;

public class PrintEx {

	public static void main(String[] args) {
		
		//System.out.printf("패턴이 포함된 문자열", 변수 또는 값);
		//"패턴이 포함된 문자열" 출력 시 
		// 패턴 자리 뒤에 작성된 변수 또는 값을 순서대로 대입
		String name = "홍길동";
		int age = 30;
		char gender = '남';
		double height = 185.5;
		
		//println();
		System.out.println(name + "님은 나이 "+ age + "세, 키 " + height
				+ "cm의 " + gender + "성입니다");
		
		//printf();
		// %s 문자열
		// %d 10진 정수 %-5d (공백 5 추가)
		// %f [%.?f (? = int) 소수점 자리 ]double,float 실수
		// %c 문자형
		// %b 논리형
		
		System.out.printf("%s님은 나이 %d세, 키 %.1fcm의 %c성입니다",name,age,height,gender);
		
		// \n  한줄띄기
		System.out.println("\nHello \t\t\tWorld\u0050");
		
	}

}
