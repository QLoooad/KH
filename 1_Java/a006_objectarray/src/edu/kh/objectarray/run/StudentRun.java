package edu.kh.objectarray.run;

import edu.kh.objectarray.view.StudentView;

public class StudentRun {
	
	/*	실행 순서
	 * 	1. static 읽기
	 * 	2. main() 메소드 실행
	 * 	3. StudetnView() 객체 생성
	 * 	4. Scanner, StudentService 객체 생성
	 * 	5. Student[5] 배열 생성
	 * 		기본 생성자 내용 수행
	 * 		-> Student 객체 3개 생성 후 
	 * 			0, 1, 2 인덱스에 주소 대업
 	 * */
	
	public static void main(String[] args) {
		
		StudentView view = new StudentView();
		
		view.displayMenu();
		
	}
	
}
