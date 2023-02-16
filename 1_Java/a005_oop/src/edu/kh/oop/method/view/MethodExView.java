package edu.kh.oop.method.view;

import java.util.Scanner;

import edu.kh.oop.method.service.MethodExService;

//view 프로그램 실행 시 보여지는 부분
//(콘솔에 입출력 받는용도의 객체를 만들기 위한 클래스)
public class MethodExView {

	// 필드( == 멤버변수)
	private Scanner sc = new Scanner(System.in);
	//클래스 내 어디서든 사용 가능 한  Scanner 객체 생성
	
	private MethodExService service = new MethodExService();
	//클래스 내 어디서든 사용 가능 한  MethodExService 객체 생성
	
	
	
	
	//void return값이 없다
	public void displayMenu() { //메뉴 출력 기능
		
		int input = 0; //입력 받은 정수 저장용 변수
		
		do {
			System.out.println("--------------------");
			System.out.println("1. 매개 변수 x, 반환 값x");
			System.out.println("2. 매개 변수 o, 반환 값x");
			System.out.println("3. 매개 변수 x, 반환 값o");
			System.out.println("4. 매개 변수 o, 반환 값o");
			System.out.println("0. 프로그램 종료");
			System.out.println("--------------------");
			
			System.out.print("메뉴 번호 입력 : ");
			input = sc.nextInt();
			System.out.println();
			
			switch(input) {
			case 1 : menu1(); break;
			case 2 : menu2(); break;
			case 3 : menu3(); break;
			case 4 : menu4();break;
			case 0 : System.out.println("<프로그램 종료>"); break;
			default : System.out.println("잘못 입력 하셧습니다.");
			}
			
		}
		while(input != 0);
			
	}
	
	//1. 매개 변수 x, 반환 값x
	//[접근제한자] [예약어] 반환형 메서드명(매개변수){}
	private void menu1() {
		System.out.println("*** menu1() 실행 ***");
		int a = 10;
		int b = 20;
		System.out.println("a + b = " + (a+b));
	}
	
	//2. 매개 변수 o, 반환 값x
	private void menu2() {
		
		System.out.println("*** menu2() 실행 ***");
		
		System.out.println("[정수 3개 입력 시 합계, 평균 출력]");
		
		System.out.print("입력 1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("입력 2 : ");
		int num2 = sc.nextInt();
		
		System.out.print("입력 3 : ");
		int num3 = sc.nextInt();
		
		service.threeNumbersSumAndAverage(num1, num2, num3);
	}
	
	//매개 변수 x, 반환 값o
	private void menu3() {
		System.out.println("*** menu3() 실행 ***");
		
		System.out.println("1~10사이 난수 5개 배열 저장 후 반환 출력");
		
		int[] numbers = service.fiveRandomNumbers();
		
		//반환된 int[]은 실제 배열이 아닌 int[]의 주소값
		//반환된 int[]을 numbers 참조변수에 저장
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		
		//메소드 재사용
		service.threeNumbersSumAndAverage(numbers[0], numbers[1], numbers[2]);
	}
	
	//매개 변수 o, 반환 값o
	private void menu4() {
		
		//정수 2개, 연산자를 입력 받아 계산서비스 호출 후
		//연산 결과 반환받아서 출력
		System.out.println("*** menu3() 실행 ***");
		System.out.println("[입력된 정수 2개, 연산자를 이용해서 계산하기]");
		
		System.out.print("정수 입력 1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("연산자 입력 1 : ");
		String op = sc.next();
		
		System.out.print("정수 입력 2 : ");
		int num2 = sc.nextInt();
		
		String result = service.calculate(num1, num2, op);
		
		System.out.println(result);
		
		
	}
	
}
