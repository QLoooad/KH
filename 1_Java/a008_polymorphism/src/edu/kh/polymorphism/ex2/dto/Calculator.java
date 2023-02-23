package edu.kh.polymorphism.ex2.dto;


//계산기 인터페이스
//모든 계산기에 대한 공통 필드, 기능명 제공
//공통 규약(이름만) 설정
public interface Calculator {
	
	
	public static final double PI = 3.14;
	final int MAX_NUM = 100_000_000;
	int MIN_NUM = -100_000_000;
	
	
	//alt + shift + j 
	/** 두 정수의 합 반환
	 * @param a
	 * @param b
	 * @return a + b
	 */
	public abstract int plus(int a, int b);
	
	
	/** 두 정수의 차 반환
	 * @param a
	 * @param b
	 * @return a - b
	 */
	int minus(int a, int b);
	
	
	/** 두 정수의 곱 반환
	 * @param a
	 * @param b
	 * @return a * b
	 */
	int multiple(int a, int b);
	
	
	/** 두 정수의 나눔 반환
	 * @param a
	 * @param b
	 * @return a / b
	 */
	int divide(int a, int b);
	
	
	/** 두 정수의 나눔 소수점까지 반환
	 * @param a
	 * @param b
	 * @return a / b 실수값
	 */
	double divide2(int a, int b);
	
	
	/** 원의 넓이 반환
	 * @param r
	 * @return PI * r^2 원의 넓이
	 */
	double areaOfCircle(double r); //원의 넓이
	
	
	/** a의 x 거급 제곱(a^x)
	 * @param a
	 * @param x
	 * @return (a^x)
	 */
	int square(int a, int x);
}
