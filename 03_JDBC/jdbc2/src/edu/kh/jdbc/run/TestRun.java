package edu.kh.jdbc.run;

// JDBCTemplate 에 존재하는 static 필드/메서드를 가져온다
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.kh.jdbc.common.JDBCTemplate;

public class TestRun {

	public static void main(String[] args) {

		// JDBCTemplate 사용 예시
		
		
		// 1. JDBC 객체 참조 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 2. 참조 변수에 알맞은 객체 대입
			/*
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost";
			String port = ":1521"; // 컴퓨터 내 응용프로그램 번호
			String dbName = ":ORCL";// DB 이름(SID)
			String user = "kh_cgt"; // 계정명
			String pw = "oracle_cgt"; // 비밀번호
			conn = DriverManager.getConnection(type + ip + port + dbName, user, pw);
			*/
			conn = getConnection();
			
			// SQL 작성
			String sql = "SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE FROM EMPLOYEE";
			
			// Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL(select) 수행 후 결과(ResultSet) 반환
			rs = stmt.executeQuery(sql);
			
			// 3. 조회 결과의 행을 반복 접근하며 출력
			while(rs.next()) {
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				Date hireDate = rs.getDate("HIRE_DATE");
				
				System.out.printf("사번 : %s | 이름 : %s | 급여 : %d | 입사일 : %s \n", 
						empId, empName, salary, hireDate.toString());
				
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// 4. 사용한 JDBC 객체 자원 반환
			close(rs);
			close(stmt);
			close(conn);
		}
				
	}

}
