package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		

		// 1단계 : JDBC 객체 참조변수 선언
		
		Connection conn = null;
		// DB연결 정보를 담은 객체,  이 정보를 이용해 Java-DB 연결 통로 생성
		
		Statement stmt = null;
		// Connection을 이용해서 SQL을 DB에 전달하여 수행 후 결과를 반환 받는 객체
		
		ResultSet rs = null;
		// SELECT 수행 결과를 저장하는 객체. 커서를 이요해 1행씩 접근
		
		try {
			// 2단계 : 참조 변수에 알맞은 객체 대입
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DB연결에 필요한 JDBC드라이버를 메모리에 로드(객체 생성)
			// -> DriverManager가 Connection 생성 시 자동으로 생성
			
			// Connection 생성 시 필요한 값을 미리 변수에 대입
			
			String type = "jdbc:oracle:thin:@";
			
			String ip = "localhost";
			// localhost == 127.0.0.1 (loop back ip ==  자신 컴 주소)
			// 115.90.212.22(강의장 DB서버 이용자)
			
			String port = ":1521"; // 컴퓨터 내 응용프로그램 번호
			// :9000 (강의장 DB서버 이용자)
			
			String dbName = ":ORCL";// DB 이름(SID)
			// 19c 버전 : :ORCL
			// 18c or 강의장DB :  :XE
			
			String user = "kh_cgt"; // 계정명
			
			
			String pw = "oracle_cgt"; // 비밀번호
			
			// Connection 생성 -> SQLException 발생 가능성 있음
			conn = DriverManager.getConnection(type + ip + port + dbName, user, pw);
			
			// Statement (통로를 이동하는 객체)생성
			// -> SQL 수행, 결과 반환
			stmt = conn.createStatement();
			
			System.out.println("급여 기준 입력 : ");
			int input = sc.nextInt();
			
			// SQL 작성
			// 급여 300만 이상 인 사원이름, 급여, 직급코드, 입사일 조회 급여내림차순
			String sql = "SELECT EMP_NAME, SALARY, JOB_CODE, HIRE_DATE "
						+ "FROM EMPLOYEE "
						+ "WHERE SALARY >= " + input
						+ " ORDER BY SALARY DESC";
			
			// Statement 객체를 이용해 SQL수행 후 결과 반환받기
			
			rs = stmt.executeQuery(sql);
			// executeQuery() : SELECT문을 수행하는 메서드
			//					결과로 ResultSet을 반환
			
			
			
			//3단계 : SQL 수행 결과로 반환 받은 ResultSet을
			// 첫번째 행부터 1행씩 접근하여 컬럼 값을 얻어와 출력
			
			while(rs.next()) {
				// rs.next() : 커서를 1행이동
				//				다음 행 있으면 true, 없으면 false
				
				
				// 각 행에 존재하는 컬럼 값 얻어오기
				// -> rs.get자료형(컬럼명|컬럼순서)
				
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				String jobCode = rs.getString("JOB_CODE");
				Date hireDate = rs.getDate("HIRE_DATE");
				// java.sql.Date hireDate = rs.getDate("HIRE_DATE");
				
				System.out.printf("이름 : %s | 급여 : %d | 직급코드 : %s | 입사일 : %s \n", 
						empName, salary, jobCode, hireDate.toString());
				
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
