package edu.kh.jdbc.run;

import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.dao.SelectJobNameDAO;
import edu.kh.jdbc.dto.Employee2;

public class JDBCExample4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 부서명 입력받아
		// 해당 부서에 존재하는 사원의
		// 사번, 이름, 급여, 부서명을 
		// 사번 오름차순으로 조회
		
		System.out.println("직급명 입력 : ");
		String jobName = sc.nextLine();
		
		// SelectDepartmentTitleDAO 객체 생성
		SelectJobNameDAO dao = new SelectJobNameDAO();
		
		List<Employee2> empList = dao.select(jobName);
		
		//결과 출력
		
		//일치하는 부서명이 없어서 조회 결과가 없을 경우
		if(empList.isEmpty()) {// empList가 비어있으면 true
								// empList.size() == 0
			System.out.println("일치하는 직급명과 일치하는 사원이 없습니다.");
			return;
			
		} 
		for(Employee2 a : empList) {
			System.out.printf("%s | %s | %s | %s \n",
					a.getDeptTitle(), a.getJobName(), a.getEmpName(), a.getEmail());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
