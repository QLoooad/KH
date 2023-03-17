package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample1 {

	public static void main(String[] args) {

		// JDBC : Java에서 DB에 연결(접근)할 수 있게 해주는 
		//		  코드(class, interface)를 제공해 주는 것
		//			-> Java Programming API 
		//			-> java.sql 패키지에서 제공 

		
		/*	** JDBC를 이용한 애플리케이션 제작 시 필요한 것 **
		 * 
		 * 1. Java의 JDBC 관련 인터페이스
		 * 2. DBMS의 종류(Oracle)
		 * 3. DBMS 회사에서 제공하는 
		 * 	  Java 애플리케이션과 DB 연결을 위한 라이브러리 
		 * 	  (ojdbc11.jar -> OracleDriver.class)
		 * */
		
		// 1단계 : JDBC 객체 참조 변수 선언
		
		
		
		Connection conn = null;
		// DB 연결 정보를 담는 객체
		// --> Connection을 상속 받아 구현한 자식 객체가 대입될 예정
		
		// DBMS 이름, 타입, IP, PORT, ID, PW
		// DBeaver의 계정 접속 방법 추가와 유사
		
		// 왜 Connection은 인터페이스?
		// -> DBMS마다 연결 정보, 방법이 다르기 때문에
		//	  상속을 받아 공통된 부분을 DBMS마다 알맞게 구현 하고
		//	  구현된 객체를 Java에서 참조해서 사용
		
		Statement stmt = null;
		// sql을 DB에 전달해 수행하고 
		// 결과(ResultSet 또는 DML 성공 행의 개수)를 
		// 반환 받을때 사용되는 객체
		
		ResultSet rs = null;
		// SELECT 질의 성공 시 반환되는 객체
		// 조회 결과의 집하블 나타냄
		// -> 테이블 모양으로 반환됨
		// -> ResultSet 객체를 이용해서 1행씩 접근
		// -> 더 이상 접근할 행이 없을 경우 false 반환
				
		
		try {
			//////////////////////////////////////////////////////////
			// 2단계 : 1단계에서 선언한 참조 변수에 알맞은 객체 대입//
			//////////////////////////////////////////////////////////
			
			// 1. DB 연결에 필요한 Oracle JDBC Driver 객체를 메모리에 로드
			// -> OracleDriver.class 를 객체로 만들어두기
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// -> () 작성된 경로에 존재하는 클래스를 이용해 객체를 생성
			// -> 메모리에 객체가 생성되고 Connection 을 이요한 DB 연결 시
			//	  이를 자동으로 참조
			
			// ClassNotFoundException 발생 가능성 있음
			// -> 오타 또는 라이브러리 추가 x 시 발생
			
			// 2. DB 연결 정보를 담은 Connection 객체 생성
			// -> DriverManager를 이용해 생성
			
			// DB 연결을 위한 정보를 변수에 저장
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
			
			// DriverManager 객체 
			// - 메모리에 로드된 JDBC드라이버 객체를 이용해
			//	 DB에 접근하고
			//	 작성된 정보를 이용해 DB와 연결 가능한
			//	 Connection 객체를 만들어 얻어오는 역할을 하는 객체
			
			conn = DriverManager.getConnection(type + ip + port + dbName, user, pw);
			
//			System.out.println(conn);
			// -> 정상적으로 작성한경우 conn 객체의 주소가 출력
			// -> 잘못 작성한 경우 예외 발생
			
			// 3. SQL 작성
			// ** Java에서 작성되는 SQL은 마지막에 세미콜론(;)을 작성하지 않는다 **
			String sql = "SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE FROM EMPLOYEE";
			
			// 4. Statement 객체 생성
			// -> DB에 SQL 전달 후 수행 -> 결과 반환
			// --> Connection 내부에 생성되어 DB와 통신하는 역할
			stmt = conn.createStatement();
			
			// 5. Statement 객체를 통해 SQL(SELECT)을 수행하고
			//	  결과(ResultSet)를 반환 받아와서 저장(rs)
			rs = stmt.executeQuery(sql);
			
			// executeQuery() : SELECT문을 수행하는 메서드
			//					결과로 ResultSet을 반환
			
			
			///////////////////////////////////////////////////////
			// 3단계 : SQL 수행 결과로 반환 받은 ResultSet을	 //
			// 첫번째 행부터 1행씩 접근하여 컬럼 값을 얻어와 출력//
			///////////////////////////////////////////////////////
			
			while(rs.next()) {
				// rs.next()
				// - ResultSet 객체는 조회 결과를 한번에 테이블로 다루는 것이 아닌
				//	 커서라는 것을 이요해서 1행씩만 접근
				// - 커서를 다음 행으로 이동 후 
				//	 행이 존재하면 true, 없으면 false
				
				// ** 현재 접근한 행의 컬럼 값을 얻어와 출력 **
				// rs.get자료형(컬럼명|컬럼순서);
				
				// [Java]			|	[DB]
				//------------------|-------------------
				// String			|	CHAR, VARCHAR2
				// int, long		|	NUMBER(정수만)
				// float, double	|	NUMBER(실수만)
				// java.sql.Date	|	DATE
				
				String empId = rs.getString("EMP_ID");
				// 현재 커서가 접근한 행의 "EMP_ID" 컬럼의 값을 얻어와
				// String으로 반환
				
				String empName = rs.getString("EMP_NAME");
				// 현재 커서가 접근한 행의 "EMP_NAME" 컬럼의 값을 얻어와
				// String으로 반환
				
				
				int salary = rs.getInt("SALARY");
				// 현재 커서가 접근한 행의 "SALARY" 컬럼의 값을 얻어와
				// int으로 반환
				
				
				Date hireDate = rs.getDate("HIRE_DATE");
				// 현재 커서가 접근한 행의 "HIRE_DATE" 컬럼의 값을 얻어와
				// Date으로 반환 (java.sql.Date hireDate = rs.getDate("HIRE_DATE");)
				
				System.out.printf("사번 : %s | 이름 : %s | 급여 : %d | 입사일 : %s \n", 
						empId, empName, salary, hireDate.toString());
				
				
			}
			
			
			
	
		} catch (ClassNotFoundException e) {
			System.out.println("지정된 경로에 클래스가 존재하지 않습니다.");
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			// SQLException : JDBC 관련 객체 이용 중 발생되는 예외으 최상위 부모
		} finally {
			// 4단계 : 사용한 JDBC 객체 자원 반환(close())
			// -> close 구문은 객체 생성 역순으로 작성
			
			// 생성 순서 : conn, stmt, re
			// close 순서 : rs, stmt, conn
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
