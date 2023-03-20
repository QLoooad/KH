package edu.kh.jdbc.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.jdbc.common.JDBCTemplate;
import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.model.dao.EmployeeDao;
import edu.kh.jdbc.model.dto.Employee;

// Model : 데이터 논리 구조 제어(트랜잭션 제어)
//			데이터 가공처리(비즈니스 로직)

//			DAO 수행 결과를 view/controller로 반환
// > 프로그램(앱)에 포함되어야할 데이터에 대한 정의

// Service : 비즈니스 로직
// - 요청에 따른 필요 데이터를 반환
// + 트랜잭션 제어처리(Commit, Rollback)


public class EmployeeService {

	// dao에 여러 SQL 을 수행하기 위한 메서드를 각각 작성하여 호출
	private EmployeeDao dao = new EmployeeDao();

	/** 전체 사원 정보 반환 서비스
	 * @return empList
	 * @throws SQLException 
	 */
	public List<Employee> selectAll() throws SQLException {
		
		// DB에서 필요한 데이터를 조회하기 위해
		// DAO 메서드를 호출
		
		// 1. 커넥션 생성
		// > Service가 트랜잭션 제어처리를 위해서는
		// Connection 객체가 Service에 존재해야함
		// 	>>>	만약 DAO에서 Connection을 만들고 반환하면
		// 	>>>	Service쪽에서 Connection을 사용할 수 없게 된다.
		
		//  >>> 커넥션이 서비스에 있다
		//	>>>> 사용 후 닫아주는 close() 구문이 필요하다
		//	>>>> 서비스에 conn.clode()가 필요
		
		Connection conn = getConnection();
		
		// 2. DAO의 메서드를 호출하여
		//		필요한 결과를 DB에서 조회해서 반환 받기
		List<Employee> empList = dao.selectAll(conn);
		
		// ** DML 구문인 경우 해당 위치에 connit/rollback 구문 작성 **
		
		// 3. Connection 반환
		close(conn);
		
		// 4. 결과 반환
		return empList;
	}
	
	public List<Employee> rangeSalary(int min, int max) throws SQLException {
		// 1. Connection 생성 (JDBCTemplate)
		Connection conn = getConnection();
		// 2. DAO의 메서드를 호출하여
		//		필요한 결과를 DB에서 조회해서 반환 받기
		List<Employee> empList = dao.rangeSalary(conn, min, max);
		
		// ** DML 구문인 경우 해당 위치에 connit/rollback 구문 작성 **
		
		// 3. Connection 반환
		close(conn);
		
		// 4. 결과 반환
		return empList;
	}
	
	
	/** 이름에 글자가 포함된 사원 조회
	 * @param input
	 * @return
	 * @throws SQLException 
	 */
	public List<Employee> selectName(String input) throws SQLException {
		
		// 1. Connection 생성 (JDBCTemplate)
		Connection conn = getConnection();
		// 2. DAO의 메서드를 호출하여
		//		필요한 결과를 DB에서 조회해서 반환 받기
		List<Employee> empList = dao.selectName(conn, input);
		
		// ** DML 구문인 경우 해당 위치에 connit/rollback 구문 작성 **
		
		// 3. Connection 반환
		close(conn);
		
		// 4. 결과 반환
		return empList;
	}

	/** 사원 1명 정보 반환 서비스
	 * @param input
	 * @return
	 * @throws SQLException 
	 */
	public Employee selectOne(int input) throws SQLException {
		
		// 1. Connection 생성 (JDBCTemplate)
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출(커넥션, input)
		Employee emp = dao.selectOne(conn, input);
		
		// 3. Connection 반환
		close(conn);
		
		return emp;
	}


	



	
	
}
