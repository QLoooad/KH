package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee2;

public class SelectJobNameDAO {
	
	public List<Employee2> select(String JobName) {
		
		List<Employee2> empList = new ArrayList<>();
		
		Connection conn = null; // DB 연결 정보 저장. Statement 통로
		Statement stmt = null; // SQL 수행, 결과 반환
		ResultSet rs = null;	// SELECT수행 결과 저장용 객체
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 메모리에 드라이버 객체 로드
			
			// DB 연결 정보
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost";
			String port = ":1521";
			String dbName = ":ORCL";// DB 이름(SID)
			// type + ip + port + dbName 합치기 가능
			
			String user = "kh_cgt"; // 계정명
			String pw = "oracle_cgt"; // 비밀번호
			
			// DriverManager를 이용해 Connection 생성 후 얻어오기
			// Connection 생성 -> SQLException 발생 가능성 있음
			conn = DriverManager.getConnection(type + ip + port + dbName, user, pw);
			
	         // SQL 작성
	         String sql =  "SELECT NVL(DEPT_TITLE, '부서없음'), JOB_NAME, EMP_NAME , EMAIL \r\n"
	         		+ "FROM EMPLOYEE\r\n"
	         		+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)\r\n"
	         		+ "LEFT JOIN JOB USING(JOB_CODE)\r\n"
	         		+ "WHERE JOB_NAME = '" + JobName
	         		+ "' ORDER BY EMP_NAME";
			
			stmt = conn.createStatement(); // Statement 객체 생성
			
			rs = stmt.executeQuery(sql); // SELECT 수행 후 결과 반환 받기
			
			// 3단계
			while(rs.next()) { // 커서 1행씩 이동 (다음 행 없을 때 까지)
				
//				String empId = rs.getString("EMP_ID");
				String deptTitle = rs.getString(1); // 조회 결과 컬럼 순서
				String jobName = rs.getString(2);
				String empName = rs.getString(3);
				String email = rs.getString(4);
				
				// 조회된 컬럼 값을 Employee1 객체에 저장
				
				Employee2 emp = new Employee2(deptTitle, jobName, empName, email);
				
				// 컬럼 값이 저장된 객체를 empList에 추가
				empList.add(emp);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4단계 : 사용한 JDBC 객체 자원 반환(close())
			try {
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return empList; // 조회 결과가 담긴 empList 반환
	}
}
/*
 * java.lang.ClassNotFoundException
- Class.forName("oracle.jdbc.driver.OracleDriver"); 
  구문에 오타가 있는 경우
  
java.sql.SQLException: ORA-01017: 
사용자명/비밀번호가 부적합, 로그온할 수 없습니다
- 아이디 또는 비밀번호 오타

java.sql.SQLRecoverableException: IO 오류: 
The Network Adapter could not establish the connection 
- DB 연결을 위한 URL (type, ip, port, dbName)에 오타


java.sql.SQLSyntaxErrorException
- SQL 문법이 잘못됨

java.sql.SQLSyntaxErrorException: ORA-00933: 
SQL 명령어가 올바르게 종료되지 않았습니다
- SQL에 세미콜론이 포함됨


java.sql.SQLException: 실행할 SQL 문은 비어 있거나 널일 수 없음
- Statement를 이용해서 SQL 수행 시 SQL이 ""(빈문자열) 또는 NULL인 경우


java.sql.SQLException: 부적합한 열 이름
- rs.get자료형("컬럼명") 구문에서 "컬럼명"을 잘못 작성한 경우
 * */
 