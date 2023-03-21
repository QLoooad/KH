package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Employee;

// DAO(Data Access Object) : DB 접근용 객체
public class EmployeeDao {

	// JDBC구문이 여러번 작성될 예정
	// > JDBC 객체 참조 변수가 계속 작성될 예정
	//	> 필드로 작성하여 재사용
	
	private Statement stmt;
	
	private PreparedStatement pstmt;
	// Prepared : 준비된
	// > 외부 변수를 SQL에 삽입될 준비가 된 Statement
	
	// PreparedStatement는 Statement 클래스의 자식 클래스
	// SQL 구분에 ? 기호를 사용해
	// SQL에 작성되는 리터럴 값을 동적으로 제어하는 기능을 가지고 있다
	
	// ? = placeholder
	
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
					/*// 2. Statement, ResultSet에 객체 대입
					
					// 2.1 SQL 작성
					// 사번, 이름, 부서명, 직급명, 
					
					String sql = "SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY\r\n"
							+ "FROM EMPLOYEE \r\n"
							+ "NATURAL JOIN JOB \r\n"
							+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) \r\n"
							+ "WHERE SALARY BETWEEN " + min + " AND " + max
							+ " ORDER BY SALARY DESC";
					
					// Statement 객체 생성
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);*/
					
					// 2. PreparedStatement 사용
					
					String sql = "SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY\r\n"
							+ "FROM EMPLOYEE \r\n"
							+ "NATURAL JOIN JOB \r\n"
							+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) \r\n"
							+ "WHERE SALARY BETWEEN ? AND ?\r\n"
							+ " ORDER BY SALARY DESC";
					// > 값이 동적으로 추가되는 부분을 ?(placeholder)로 작성
					
					// PreparedStatement 객체 생성
					pstmt = conn.prepareStatement(sql);
					
					
					// 미완성된(?) 부분에 알맞은 값 추가
					// pstmt.set자료형([?]의 순서, 값)
					pstmt.setInt(1, min);
					pstmt.setInt(2, max);
					
					// 준비가 완료된 PreparedStatement를 이용해 
					// SQL수행 후 결과 반환 받기
					rs = pstmt.executeQuery();
					// PreparedStatement 객체 생성 시 이미 SQL이 담겨있기에
					// SQL 수행 구문에서 따로 매개변수를 넣지 않는다
					
					
					// 3. 조회 결과 1행씩 접근하여 컬럼 값을 얻어와 List에 담기
					
					while(rs.next()) {
						
						int empId = rs.getInt("EMP_ID");
						String empName = rs.getString(2);
						String jobName = rs.getString(3);
						int salary = rs.getInt(4);
						
						Employee emp = new Employee(empId, empName, jobName, salary);
						
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

	/** 사원 정보 삽입 SQL 수행 후 결과 행 개수 반환
	 * @param conn
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int insertEmployee(Connection conn, Employee emp) throws SQLException {

		// DML 수행 시 영향을 끼친 행의 개수가 반환된다
		// (삽입된 행 개수, 수정된 행 개수, 삭제된 행 개수)
		// 행 개수 == 숫자(정수) == INT 사용
		
		// 1. 결과를 저장할 변수/객체 선언
		int result = 0;
		
		try {
			// 2. PreparedStatement 객체 생성
			
			// 2.1 SQL 작성
			String sql = "INSERT INTO EMPLOYEE VALUES(SQE_EMP_ID.NEXTVAL,"
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N')";
			// 2.2 PreparedStatement 생성 후 placeholder 에 값 세팅
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpNo());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPhone());
			pstmt.setString(5, emp.getDeptCode());
			pstmt.setString(6, emp.getJobCode());
			pstmt.setString(7, emp.getSalLevel());
			pstmt.setInt(8, emp.getSalary());
			pstmt.setDouble(9, emp.getBonus());
			pstmt.setInt(10, emp.getManagerId());

			// 3. SQL 수행 후 결과 반환 받기
			// executeQuery() : SELECT 수행 후 ResultSet 반환
			// executeUpdate() : DML 수행 후 결과 행의 개수 반환
			
			result = pstmt.executeUpdate();
			
			// SELECT와 다르게 옮겨 담는 과정이 없다
			
		} finally {
			// 4. JDBC 객체 자원 반환
			close(pstmt);
			// > Statement를 close() 하는 메서드 호출
			//		(매개변수에 다형성 업캐스팅 적용)
		
		}
		
		
		// 결과 반환
		return result;
	}

	/** 사원 정보를 수정하는 SQL 수행 후 결과 행 개수 반환하는 메서드
	 * @param conn
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int updateEmployee(Connection conn, Employee emp) throws SQLException{
		
		// 1. 결과 저장용 변수/객체 선언
		int result = 0;
		
		try {
			// 2. PreaparedStatement 생성
			// 2.1 SQL 작성
			String sql = "UPDATE EMPLOYEE\r\n"
					+ "SET EMAIL = ?,\r\n"
					+ "	PHONE = ?,\r\n"
					+ "	SALARY = ?\r\n"
					+ "WHERE EMP_ID = ?";
			// 2.2 PreaparedStatement 생성 후 placeholder에 값 세팅
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setInt(4, emp.getEmpId());
			
			// set잘형() 으로 ?에 값을 세팅할 때
			// 자료형에 맞는 DB리터럴 표기법으로 변환되서 세팅됨
			
			//setString(1, asd123@naver.com); >> 'asd123@naver.com'
			//setInt(1, 12000); >> 12000
			//setDouble(1, 0.1); >> 0.1
			// setDate(순서, java.sql.Date) > DB DATE타입
			
			
			// 3. 수행 후 결과 반환받기
			result = pstmt.executeUpdate();
			//매개변수에 SQL 작성x
			
		} finally {
			
			// 4. JDBC 객체 자원 반환
			close(pstmt);
		}
		
		// 5.결과반환
		return result;
	}

	/** 퇴사 처리 후 결과 반환
	 * @param conn
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int retireEmployee(Connection conn, int input) throws SQLException {
		// 1. 결과 저장용 변수/객체 선언
		int result = 0;
		
		try {
			// 2. PreaparedStatement 생성
			// 2.1 SQL 작성
			String sql = "UPDATE EMPLOYEE\r\n"
					+ "SET ENT_YN = 'Y',\r\n"
					+ "	ENT_DATE = SYSDATE\r\n"
					+ "WHERE EMP_ID = ?";
			// 2.2 PreaparedStatement 생성 후 placeholder에 값 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			
			// set잘형() 으로 ?에 값을 세팅할 때
			// 자료형에 맞는 DB리터럴 표기법으로 변환되서 세팅됨
			
			//setString(1, asd123@naver.com); >> 'asd123@naver.com'
			//setInt(1, 12000); >> 12000
			//setDouble(1, 0.1); >> 0.1
			// setDate(순서, java.sql.Date) > DB DATE타입
			
			
			// 3. 수행 후 결과 반환받기
			result = pstmt.executeUpdate();
			//매개변수에 SQL 작성x
			
		} finally {
			
			// 4. JDBC 객체 자원 반환
			close(pstmt);
		}
		
		// 5.결과반환
		return result;
	}

	public int deleteEmployee(Connection conn, int input) throws SQLException {
		// 1. 결과 저장용 변수/객체 선언
		int result = 0;
		
		try {
			// 2. PreaparedStatement 생성
			// 2.1 SQL 작성
			String sql = "DELETE FROM EMPLOYEE\r\n"
					+ "WHERE EMP_ID = ?";
			// 2.2 PreaparedStatement 생성 후 placeholder에 값 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			
			// set잘형() 으로 ?에 값을 세팅할 때
			// 자료형에 맞는 DB리터럴 표기법으로 변환되서 세팅됨
			
			//setString(1, asd123@naver.com); >> 'asd123@naver.com'
			//setInt(1, 12000); >> 12000
			//setDouble(1, 0.1); >> 0.1
			// setDate(순서, java.sql.Date) > DB DATE타입
			
			
			// 3. 수행 후 결과 반환받기
			result = pstmt.executeUpdate();
			//매개변수에 SQL 작성x
			
		} finally {
			
			// 4. JDBC 객체 자원 반환
			close(pstmt);
		}
		
		// 5.결과반환
		return result;
	}

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
