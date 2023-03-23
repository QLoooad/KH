package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;

public class EmpService {

	private EmpDAO dao = new EmpDAO();

	public List<Emp> inOfficeEmp() throws SQLException {
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.inOfficeEmp(conn);
		
		close(conn);
		
		return empList;
		
	}

	public List<Emp> retireList() throws SQLException {
		Connection conn = getConnection();
		
		List<Emp> empList = dao.retireList(conn);
		
		close(conn);
		
		return empList;
	}

	public Emp findEmpId(int input) throws SQLException {
		Connection conn = getConnection();
		
		Emp empList = dao.findEmpId(conn, input);
		
		close(conn);
		
		return empList;
	}

	public int insertEmployee(Emp emp) throws SQLException {
		Connection conn = getConnection();
		
		int result = dao.insertEmployee(conn, emp);
		
		
		if(result > 0) 
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public int updateEmployee(Emp emp) throws SQLException {
		Connection conn = getConnection();

		int result = dao.updateEmployee(conn, emp);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public int deleteEmployee(int input) throws SQLException {
		Connection conn = getConnection();
		
		int result = dao.deleteEmployee(conn, input);
		
		
		if(result > 0) 
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public int retireEmployee(int input) throws SQLException {
		Connection conn = getConnection();
		
		int result = dao.retireEmployee(conn, input);
		
		
		if(result > 0) 
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}
	public void retireEmployee2(int input) throws SQLException {
		Connection conn = getConnection();
		
		dao.retireEmployee2(conn, input);
		
		commit(conn);

		close(conn);
	}

	public List<Emp> lastDayOfHireDate() throws SQLException {
		Connection conn = getConnection();
		
		List<Emp> empList = dao.lastDayOfHireDate(conn);
		
		close(conn);
		
		return empList;
	}

	public List<Emp> DepartmentalStatistics() throws SQLException {
		Connection conn = getConnection();
		
		List<Emp> empList = dao.DepartmentalStatistics(conn);
		
		close(conn);
		
		return empList;
	}
	
	public Map<String, ArrayList<String>> DepartmentalStatisticsLinkedHashMap() throws SQLException {
		Connection conn = getConnection();
		
		Map<String, ArrayList<String>> empList = dao.DepartmentalStatisticsLinkedHashMap(conn);
		
		close(conn);
		
		return empList;
	}

	/** 사원의 퇴사유무, 존재유무 결과 반환
	 * @param input
	 * @return check(0 : 없는 사원, 1 : 퇴직한 사원, 2 : 재직중인 사원)
	 * @throws SQLException 
	 */
	public int checkEmployee(int input) throws SQLException {
		Connection conn = getConnection();
		
		int check = dao.checkEmployee(conn, input);
		
		close(conn);

		return check;
	}

	/** 부서별 통계 조회 서비스
	 * @return mapList
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectDepartment() throws SQLException{

		Connection conn = getConnection();
		
		List<Map<String, Object>> mapList = dao.selectDepartment(conn);
		
		close(conn);
		
		return mapList;
		
	}
}
