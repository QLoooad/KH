package edu.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.common.JDBCTemplate;
import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.model.dto.Employee;

// DAO(Data Access Object) : DB 접근용 객체
public class EmployeeDao {

	// JDBC구문이 여러번 작성될 예정
	// > JDBC 객체 참조 변수가 계속 작성될 예정
	//	> 필드로 작성하여 재사용
	
	private Statement stmt;
	private ResultSet rs;
	
	
	/** 전체 사원 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectAll(Connection conn) throws SQLException {

		// 1. 결과 저장을 위한 변수/객체 준비
		List<Employee> empList = new ArrayList<>();
		
		try {
			// 2. Statement, ResultSet에 객체 대입
			
			// 2.1 SQL 작성
			// 사번, 이름, 부서명, 직급명, 
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음')DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음')PHONE "
					+ "FROM EMPLOYEE "
					+ "NATURAL JOIN JOB "
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) "
					+ "ORDER BY JOB_CODE";
			
			// Statement 객체 생성
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 3. 조회 결과 1행씩 접근하여 컬럼 값을 얻어와 List에 담기
			
			while(rs.next()) {
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString(2);
				String deptName = rs.getString(3);
				String jobName = rs.getString(4);
				String phone = rs.getString(5);
				
				Employee emp = new Employee(Integer.parseInt(empId), empName, phone, deptName, jobName);
				
				empList.add(emp);
				
			}
			
		} finally {
			// catch문 대신 throws 구문으로 예외 처리
			
			// 4. JDBC 객체 자원 반환(단, conn 제외)
			close(rs);
			close(stmt);
		}
		// 5. 결과 반환
		return empList;
	}
	
	/** 이름에 글자가 포함된 사원 조회
	 * @param conn
	 * @return
	 * @throws SQLException 
	 */
	public List<Employee> selectName(Connection conn, String input) throws SQLException {

		// 1. 결과 저장을 위한 변수/객체 준비
		List<Employee> empList = new ArrayList<>();
		
		try {
			// 2. Statement, ResultSet에 객체 대입
			
			// 2.1 SQL 작성
			// 사번, 이름, 부서명, 직급명, 
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음')DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음')PHONE \r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "NATURAL JOIN JOB \r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) \r\n"
					+ "WHERE EMP_NAME LIKE '%" + input + "%'";
			
			// Statement 객체 생성
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 3. 조회 결과 1행씩 접근하여 컬럼 값을 얻어와 List에 담기
			
			while(rs.next()) {
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString(2);
				String deptName = rs.getString(3);
				String jobName = rs.getString(4);
				String phone = rs.getString(5);
				
				Employee emp = new Employee(Integer.parseInt(empId), empName, phone, deptName, jobName);
				
				empList.add(emp);
				
			}
			
		} finally {
			// catch문 대신 throws 구문으로 예외 처리
			
			// 4. JDBC 객체 자원 반환(단, conn 제외)
			close(rs);
			close(stmt);
		}
		// 5. 결과 반환
		return empList;
	}
	
	
	public List<Employee> rangeSalary(Connection conn, int min, int max) throws SQLException {
		// 1. 결과 저장을 위한 변수/객체 준비
				List<Employee> empList = new ArrayList<>();
				
				try {
					// 2. Statement, ResultSet에 객체 대입
					
					// 2.1 SQL 작성
					// 사번, 이름, 부서명, 직급명, 
					
					String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음')DEPT_TITLE, SALARY\r\n"
							+ "FROM EMPLOYEE \r\n"
							+ "NATURAL JOIN JOB \r\n"
							+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) \r\n"
							+ "WHERE SALARY BETWEEN " + min + " AND " + max
							+ " ORDER BY SALARY DESC";
					
					// Statement 객체 생성
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					
					// 3. 조회 결과 1행씩 접근하여 컬럼 값을 얻어와 List에 담기
					
					while(rs.next()) {
						
						int empId = rs.getInt("EMP_ID");
						String empName = rs.getString(2);
						String deptName = rs.getString(3);
						int salary = rs.getInt(4);
						
						Employee emp = new Employee(empId, empName, deptName, salary);
						
						empList.add(emp);
						
					}
					
				} finally {
					// catch문 대신 throws 구문으로 예외 처리
					
					// 4. JDBC 객체 자원 반환(단, conn 제외)
					close(rs);
					close(stmt);
				}
				// 5. 결과 반환
				return empList;
	}


	/** 사원 1명 정보 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return
	 */
	public Employee selectOne(Connection conn, int input) throws SQLException {
		
		// 1. 결과 저장을 위한 변수/객체 준비
		Employee emp = null;
		// > 조회 결과가 있을 경우에 객체 생성
		
		try {
			// 2. SQL 작성 후 수행
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음')DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음')PHONE \r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "NATURAL JOIN JOB \r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) \r\n"
					+ "WHERE EMP_ID = " + input;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			// 3. 조회 결과 유무 확인 후
			//		유 : Employee 객체 생성 후 emp에 대입
			if(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				// DB에서 값을 얻어올 때
				// "숫자"(문자열로 된 숫자) 형태일 경우
				// getInt() 를 작성하면 자동으로 int 형변환 진행
				String empName = rs.getString(2);
				String deptName = rs.getString(3);
				String jobName = rs.getString(4);
				String phone = rs.getString(5);
				
				emp = new Employee(empId, empName, phone, deptName, jobName);
			}
			
			
		} finally {
			// 4. JDBC 객체 자원 반환 (conn 제외)
			close(stmt);
			close(rs);
		}
		// 5. 결과 반환
		return emp;
	}

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
