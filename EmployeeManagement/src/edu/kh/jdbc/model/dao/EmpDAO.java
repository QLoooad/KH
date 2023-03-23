package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dto.Emp;

public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public List<Emp> inOfficeEmp(Connection conn) throws SQLException {
		List<Emp> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT EMP_ID ,EMP_NAME,NVL(DEPT_TITLE, '없음') ,JOB_NAME,SALARY,NVL(PHONE, '없음'),EMAIL\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE ENT_YN = 'N'\r\n"
					+ "ORDER BY JOB_CODE DESC";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString(2);
				String deptName = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(5);
				String email = rs.getString(6);
				
				Emp emp = new Emp(empId, empName, deptName, jobName, salary, phone,
						email);
				
				empList.add(emp);
				
			}
			
		} finally {
			
			close(rs);
			close(stmt);
		}
		return empList;
	}
	public List<Emp> retireList(Connection conn) throws SQLException {
		List<Emp> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT EMP_ID ,EMP_NAME, PHONE, EMAIL, ENT_DATE\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "WHERE ENT_YN = 'Y'\r\n"
					+ "ORDER BY JOB_CODE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String entDate = rs.getString(5);
				
				Emp emp = new Emp(empId, empName, email, phone, entDate);
				
				empList.add(emp);
				
			}
			
		} finally {
			
			close(rs);
			close(stmt);
		}
		return empList;
	}
	public Emp findEmpId(Connection conn, int input) throws SQLException {
		// 1. 결과 저장을 위한 변수/객체 준비
		Emp emp = null;
		// > 조회 결과가 있을 경우에 객체 생성
		
		try {
			// 2. SQL 작성 후 수행
			String sql = "SELECT EMP_ID ,EMP_NAME,DEPT_TITLE ,JOB_NAME,SALARY,PHONE,EMAIL,\r\n"
					+ "		HIRE_DATE, ENT_YN\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE EMP_ID = " + input;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			// 3. 조회 결과 유무 확인 후
			//		유 : Employee 객체 생성 후 emp에 대입
			if(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString(2);
				String deptName = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				Date hireDate = rs.getDate(8);
				String entTn = rs.getString(9);
				
				emp = new Emp(empId, empName, deptName, jobName, salary, phone, email, hireDate, entTn);
			}
			
			
		} finally {
			// 4. JDBC 객체 자원 반환 (conn 제외)
			close(stmt);
			close(rs);
		}
		// 5. 결과 반환
		return emp;

	}

	public int insertEmployee(Connection conn, Emp emp) throws SQLException {
		int result = 0;

		try {

			String sql = "INSERT INTO EMPLOYEE VALUES(SQE_EMP_ID.NEXTVAL,"
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N')";

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

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);

		}

		return result;
	}
	public int updateEmployee(Connection conn, Emp emp) throws SQLException {
		int result = 0;

		try {
			String sql = "UPDATE EMPLOYEE\r\n"
					+ "SET EMAIL = ?, PHONE = ?, SALARY = ?, BONUS = ?\r\n"
					+ "WHERE EMP_ID = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setDouble(4, emp.getBonus());
			pstmt.setInt(5, emp.getEmpId());
			
			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}
	public int deleteEmployee(Connection conn, int input) throws SQLException {
		int result = 0;

		try {
			String sql = "DELETE FROM EMPLOYEE\r\n" + "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}

	public int retireEmployee(Connection conn, int input) throws SQLException {

		int result = 0;

		try {
			String sql = "UPDATE EMPLOYEE\r\n" + "SET ENT_YN = 'Y',\r\n" + "	ENT_DATE = SYSDATE\r\n"
					+ "WHERE EMP_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			result = pstmt.executeUpdate();

		} finally {

			close(pstmt);
		}

		return result;
	}
	
	public void retireEmployee2(Connection conn, int input) throws SQLException {


		try {
			String sql = "UPDATE EMPLOYEE\r\n" + "SET ENT_YN = 'Y',\r\n" + "	ENT_DATE = SYSDATE\r\n"
					+ "WHERE EMP_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			pstmt.executeUpdate();

		} finally {

			close(pstmt);
		}

	}
	public List<Emp> lastDayOfHireDate(Connection conn) throws SQLException {
		List<Emp> empList = new ArrayList<>();

		try {
			String sql = "SELECT EMP_ID ,EMP_NAME ,DEPT_TITLE, HIRE_DATE\r\n"
					+ "FROM(SELECT EMP_ID ,EMP_NAME ,DEPT_TITLE, HIRE_DATE\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)\r\n"
					+ "ORDER BY HIRE_DATE DESC)\r\n"
					+ "WHERE ROWNUM <= 5";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString(2);
				String deptName = rs.getString(3);
				Date hireDate = rs.getDate(4);

				Emp emp = new Emp(empId, empName, deptName, hireDate);

				empList.add(emp);

			}

		} finally {

			close(rs);
			close(stmt);
		}
		return empList;
	}
	public List<Emp> DepartmentalStatistics(Connection conn) throws SQLException {
		List<Emp> empList = new ArrayList<>();

		try {
			String sql = "SELECT DEPT_TITLE, \"인원 수\", SALARY\r\n"
					+ "FROM (SELECT DEPT_CODE,DEPT_TITLE, COUNT(*) \"인원 수\", AVG(SALARY) SALARY\r\n"
					+ "		FROM EMPLOYEE\r\n"
					+ "		JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)\r\n"
					+ "		GROUP BY DEPT_CODE,DEPT_TITLE\r\n"
					+ "		ORDER BY DEPT_CODE DESC)";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				String deptName = rs.getString(1);
				int peopleNum = rs.getInt(2);
				int salary = rs.getInt(3);

				Emp emp = new Emp(deptName, peopleNum, salary);

				empList.add(emp);

			}

		} finally {

			close(rs);
			close(stmt);
		}
		return empList;
	}
	
	public Map<String, ArrayList<String>> DepartmentalStatisticsLinkedHashMap(Connection conn) throws SQLException {
		Map<String, ArrayList<String>> empList = new LinkedHashMap<String, ArrayList<String>>();
		
		try {
			String sql = "SELECT DEPT_TITLE, \"인원 수\", SALARY\r\n"
					+ "FROM (SELECT DEPT_CODE, NVL(DEPT_TITLE, '부서없음') DEPT_TITLE, COUNT(*) \"인원 수\", AVG(SALARY) SALARY\r\n"
					+ "		FROM EMPLOYEE\r\n"
					+ "		JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)\r\n"
					+ "		GROUP BY DEPT_CODE,DEPT_TITLE\r\n"
					+ "		ORDER BY DEPT_CODE DESC)";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ArrayList<String> values = new ArrayList<String>();
				String deptName = rs.getString(1);
				int peopleNum = rs.getInt(2);
				int salary = rs.getInt(3);
				
				String amount = String.valueOf(salary);
				amount = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
				
				values.add(String.valueOf(peopleNum));
				values.add(amount);
				
				empList.put(deptName, values);
			}
		} finally {

			close(rs);
			close(stmt);
		}
		return empList;
	}
	
	
	
	/** 사원의 퇴사유무, 존재유무 sql 수행 후결과 반환
	 * @param input
	 * @return check(0 : 없는 사원, 1 : 퇴직한 사원, 2 : 재직중인 사원)
	 * @throws SQLException 
	 */
	public int checkEmployee(Connection conn, int input) throws SQLException {

		int check = 0;
		
		try {
			String sql = "SELECT \r\n"
					+ "		CASE\r\n"
					+ "			WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = ? ) = 0\r\n"
					+ "			THEN 0\r\n"
					+ "		\r\n"
					+ "			WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = ? AND ENT_YN = 'Y') = 1\r\n"
					+ "			THEN 1\r\n"
					+ "			\r\n"
					+ "			ELSE 2\r\n"
					+ "		END \"CHECK\"\r\n"
					+ "FROM DUAL";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			pstmt.setInt(2, input);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = rs.getInt("CHECK");
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return check;
	}
	
	/** 부서별 통계 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectDepartment(Connection conn) throws SQLException{
		// 1. 결과 저장용 객체 생성
		List<Map<String, Object>> mapList = new ArrayList<>();
		
		try {
			String sql = "SELECT DEPT_TITLE, \"인원 수\", SALARY\r\n"
					+ "FROM (SELECT DEPT_CODE, NVL(DEPT_TITLE, '부서없음') DEPT_TITLE, COUNT(*) \"인원 수\", AVG(SALARY) SALARY\r\n"
					+ "		FROM EMPLOYEE\r\n"
					+ "		JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)\r\n"
					+ "		GROUP BY DEPT_CODE,DEPT_TITLE\r\n"
					+ "		ORDER BY DEPT_CODE DESC)";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String deptTitle = rs.getString(1);
				int count = rs.getInt(2);
				int avg = rs.getInt(3);
				
				Map<String, Object> map = new LinkedHashMap<>();
				
				map.put("deptTitle", deptTitle);
				map.put("count", count);
				map.put("avg", avg);
				
				mapList.add(map);
				
				
			}
			
		} finally {


		
		}
		
		return mapList;
	}

}
