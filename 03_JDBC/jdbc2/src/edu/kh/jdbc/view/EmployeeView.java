package edu.kh.jdbc.view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Employee;
import edu.kh.jdbc.model.service.EmployeeService;

// 값 입출력용 클래스
// 사용자와 연결되는 클래스 == User Interface (UI)

public class EmployeeView {
	
	private Scanner sc = new Scanner(System.in);
	
	private EmployeeService service = new EmployeeService();
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
			
			try {
				
				System.out.println("\n----------------------------------\n");
				System.out.println("------- 사원 관리 프로그램 -------");
				System.out.println("1. 전체 사원 조회"); // 사번, 이름, 부서명, 직급명, 전화번호
														 // 직급코드 오름차순
				System.out.println("2. 사번이 일치하는 사원 조회");
				// 사번, 이름, 부서명, 직급명, 전화번호 1행 조회
				
				System.out.println("3. 이름에 입력한 글자가 포함된 사원 조회");
				// 사번, 이름, 부서명, 직급명, 전화번호 N행 조회
				// 사번 오름차순
				
				System.out.println("4. 급여 범위로 조회");
				// 사번, 이름, 직급명, 급여 조회
				// 급여 내림차순
				
				System.out.println("5. 사원 정보 추가");
				// INSERT, SEQUENCE 사용
				
				System.out.println("6. 사번으로 사원 정보 수정");
				// 이메일, 전화번호, 급여 수정
				
				System.out.println("7. 사번으로 사원 퇴사");
				// ENT_YN, ENT_DATE 수정
				
				
				System.out.println("8. 사번으로 사원 정보 삭제");
				// DELETE
				
				System.out.println("0. 프로그램 종료");
				
				System.out.print("메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				case 1 : selectAll(); break;
				case 2 : selectOne(); break;
				case 3 : selectName(); break;
				case 4 : rangeSalary(); break;
				case 5 : insertEmployee(); break;
				case 6 : updateEmployee(); break;
				case 7 : retireEmployee(); break;
				case 8 : deleteEmployee(); break;
				case 0 : System.out.println("\n[프로그램을 종료합니다.]\n"); break;
				default : System.out.println("\n[메뉴에 존재하는 번호를 입력하세요.]\n");
				}
				
				
				
				
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println("\n[잘못된 입력입니다.]\n");
				sc.nextLine(); // 입력 버퍼 남아있는 문자열 제거
				input = -1; // while문이 종료되지 않게하기 위한 값 대입
			}
			
		} while (input != 0);
	}
	

	private void deleteEmployee() {
		System.out.println("\n----- 사번으로 사원 삭제 -----\n");
		System.out.print("삭제 처리 할 사원의 사번 입력 : ");
		int input = sc.nextInt();
		
		System.out.println("정말 삭제처리 하시겠습니까? Y/N");
		char check = sc.next().toUpperCase().charAt(0);
		
		if(check == 'N') {
			System.out.println("취소되었습니다.");
			return;
		}
		if(check != 'Y') {
			System.out.println("잘못 입력 하셧습니다.");
			return;
		}
		
		//서비스 호출 후 결과 반환 받기
		try {
			int result = service.deleteEmployee(input);
			if(result > 0) {
				System.out.println("삭제 처리가 완료되었습니다");
			}else {
				System.out.println("사번이 일치하는 사원이 없습니다");
			}
		} catch (SQLException e) {
			System.out.println("삭제 처리 중 예외 발생");
			e.printStackTrace();
		}
	}


	/**
	 * 사번으로 사원 퇴사
	 */
	private void retireEmployee() {
		System.out.println("\n----- 사번으로 사원 퇴사 -----\n");
		System.out.print("퇴사 처리 할 사원의 사번 입력 : ");
		int input = sc.nextInt();
		
		System.out.println("정말 퇴사처리 하시겠습니까? Y/N");
		char check = sc.next().toUpperCase().charAt(0);
		
		if(check == 'N') {
			System.out.println("취소되었습니다.");
			return;
		}
		if(check != 'Y') {
			System.out.println("잘못 입력 하셧습니다.");
			return;
		}
		
		//서비스 호출 후 결과 반환 받기
		try {
			int result = service.retireEmployee(input);
			if(result > 0) {
				System.out.println("퇴사 처리가 완료되었습니다");
			}else {
				System.out.println("사번이 일치하는 사원이 없습니다");
			}
		} catch (SQLException e) {
			System.out.println("퇴사 처리 중 예외 발생");
			e.printStackTrace();
		}
		// 성공 : [퇴사 처리가 완료되었습니다] 
		// 실패 : [사번이 일치하는 사원이 없습니다]
		// 예외 : [퇴사 처리 중 예외 발생]
		
	}


	/**
	 * 사번으로 사원 정보(이메일, 전화번호, 급여) 수정
	 */
	private void updateEmployee() {
		System.out.println("\n----- 사번으로 사원 정보 수정 -----\n");
		System.out.print("수정할 사원의 사번 : ");
		int empId = sc.nextInt();
		
		System.out.print("이메일  : ");
		String email = sc.next();
		
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		System.out.print("급여 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		
		// 입력 받은 값을 한번에 전달하기 위한 Employee 객체 생성
		Employee emp = new Employee();
		
		emp.setEmpId(empId);
		emp.setEmail(email);
		emp.setPhone(phone);
		emp.setSalary(salary);
		
		// 회원 정보 수정 서비스 호출 후 결과 반환 받기
		// dml 수행 시 행의 결과 result
		try {
			int result = service.updateEmployee(emp);
			if(result > 0) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
			
		} catch (SQLException e) {
			System.out.println("\n[회원 정보 수정 중 예외 발생]\n");
			e.printStackTrace();
		}
		
	}


	/** 
	 * 사원 추가
	 */
	private void insertEmployee() {
		System.out.println("\n----- 사원 추가 -----\n");
	      System.out.print("이름 : ");
	      String empName = sc.next();
	      
	      System.out.print("주민등록번호 : ");
	      String empNo = sc.next();
	      
	      System.out.print("이메일 : ");
	      String email = sc.next();
	      
	      System.out.print("전화번호(-제외) : ");
	      String phone = sc.next();
	      
	      System.out.print("부서코드(D1~D9) : ");
	      String deptCode = sc.next();
	      
	      System.out.print("직급코드(J1~J7) : ");
	      String jobCode = sc.next();
	      
	      System.out.print("급여등급(S1~S6) : ");
	      String salLevel = sc.next();
	      
	      System.out.print("급여 : ");
	      int salary = sc.nextInt();
	      
	      System.out.print("보너스 : ");
	      double bonus = sc.nextDouble();
	      
	      System.out.print("사수번호 : ");
	      int managerId = sc.nextInt();
	      sc.nextLine();
	      
	      // Employee 객체 생성 후 입력 받은 값 담기
	      Employee emp = new Employee(empName, empNo, email, phone, salary, 
	    		  deptCode, jobCode, salLevel, bonus, managerId);
	      
	     
	      
	      // 사원 정보를 DB에 삽입하는 서비스 호출 후 결과 반환 받기
	      try {
			int result = service.insertEmployee(emp);
			
			if(result > 0) {//성공
				System.out.println("[삽입 성공]");
			}else {
				System.out.println("[삽입 실패]");
			}
			
		} catch (SQLException e) {
			System.out.println("\n[사원 정보 삽입 중 예외 발생]\n");
			e.printStackTrace();
		}
	     
	      
	      
	}


	/**
	 * 
	 */
	private void rangeSalary() {
		// 사번, 이름, 직급명, 전화번호
		
		System.out.println("\n----- 급여 범위 조회 -----\n");
		System.out.print("급여 범위 입력 1 (숫자): ");
		int input1 = sc.nextInt();
		sc.nextLine();
		System.out.print("급여 범위 입력 2 (숫자): ");
		int input2 = sc.nextInt();
		sc.nextLine();
		
		
		int min = 0;
		int max = 0;
		if(input1 > input2) {
			max = input1;
			min = input2;
		}else {
			max = input2;
			min = input1;
		}
		
		try {
			// Db에서 전체 사원 정보를 조회하는 sevice
			// selectAll()을 호출하여 결과 반환
			List<Employee> empList = service.rangeSalary(min, max);
			
			if(empList.isEmpty()) {// 조회된 사원이 없을 경우
				System.out.println("[사원이 존재하지 않습니다.]");
				return;
			}
			
			// 향상된for문 이용, 모든 사원 정보 출력
			for(Employee emp : empList) {
				System.out.printf("%d / %s / %s / %d \n", 
						emp.getEmpId(),
						emp.getEmpName(),
						emp.getJobName(),
						emp.getSalary());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n[급여 범위 조회 조회 중 예외 발생]\n");
		}
	}
	
	/**
	 * 이름에 글자가 포함된 사원 조회
	 */
	private void selectName() {

		System.out.println("\n----- 이름에 글자가 포함된 사원 조회 -----\n");
		
		// 입력 : 동
		// 200 / 선동일 / 총무부 / 대표 / 01099546325 
		// 213 / 하동운 / 없음 / 대리 / 01158456632 
				
		// 입력 : 선동
		// 200 / 선동일 / 총무부 / 대표 / 01099546325 
		  
		// 입력 : a
		// [입력된 글자를 포함하는 이름의 사원이 없습니다.]
		  
		// 입력 : 동
		// (SQLException 발생)
		// [글자가 이름에 포함된 사원 조회 중 예외 발생.] 
		
		System.out.print("이름에 포함될 글자 입력 : ");
		String input = sc.nextLine();
		
		try {
			// Db에서 전체 사원 정보를 조회하는 sevice
			// selectAll()을 호출하여 결과 반환
			List<Employee> empList = service.selectName(input);
			
			if(empList.isEmpty()) {// 조회된 사원이 없을 경우
				System.out.println("[입력된 글자를 포함하는 이름의 사원이 없습니다.]");
				return;
			}
			
			// 향상된for문 이용, 모든 사원 정보 출력
			for(Employee emp : empList) {
				System.out.printf("%d / %s / %s / %s / %s \n", 
						emp.getEmpId(),
						emp.getEmpName(),
						emp.getDepartmentTitle(),
						emp.getJobName(),
						emp.getPhone());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n[글자가 이름에 포함된 사원 조회 중 예외 발생.]\n");
		}
		
		
	}
	
	private void selectAll() {
		// 사번, 이름, 부서명, 직급명, 전화번호
		
		System.out.println("\n----- 전체 사원 조회 -----\n");
		
		try {
			// Db에서 전체 사원 정보를 조회하는 sevice
			// selectAll()을 호출하여 결과 반환
			List<Employee> empList = service.selectAll();
			
			if(empList.isEmpty()) {// 조회된 사원이 없을 경우
				System.out.println("[사원이 존재하지 않습니다.]");
				return;
			}
			
			// 향상된for문 이용, 모든 사원 정보 출력
			for(Employee emp : empList) {
				System.out.printf("%d / %s / %s / %s / %s \n", 
						emp.getEmpId(),
						emp.getEmpName(),
						emp.getDepartmentTitle(),
						emp.getJobName(),
						emp.getPhone());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n[사원 전체 정보 조회 중 예외 발생]\n");
		}
	}
	
	
	
	/**
	 * 사번으로 사원 조회(1명)
	 */
	private void selectOne() {
		
		System.out.println("\n----- 사번으로 사원 조회(1명) -----\n");
		
		System.out.print("사번 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		// Service 메서드에 사번 전달 후 사번이 일치하는 사원 정보 반환
		
		try {
			Employee emp = service.selectOne(input);
			
			if(emp == null) {//조회 결과가 없는 경우.
				System.out.println("[일치하는 사번의 사원이 존재하지 않습니다.]");
				return;
			}
			System.out.printf("%d / %s / %s / %s / %s \n", 
					emp.getEmpId(),
					emp.getEmpName(),
					emp.getDepartmentTitle(),
					emp.getJobName(),
					emp.getPhone());
			
		} catch (SQLException e) {
			System.out.println("\n[사번으로 사원 조회 중 예외 발생.]\n");
			e.printStackTrace();
		}
		
	}
	

	
	
	
	

}
