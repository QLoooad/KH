package edu.kh.jdbc.main.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.main.model.dao.MainDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MainService {

	private MainDAO dao = new MainDAO();

	/**
	 * @param memberId
	 * @param memberPw
	 * @return member
	 * @throws Exception
	 */
	public Member login(String memberId, String memberPw) throws Exception {

		// 1. Connection 생성
		Connection conn = getConnection();
		
		// 2. DAO 호출
		Member member = dao.login(conn, memberId, memberPw);
		
		// 3. Connection 반환
		close(conn);
		
		// 4. 결과 반환
		return member;
	}

	/**	아이디 중복 검사 서비스
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int idDuplicateCheck(String memberId) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.idDuplicateCheck(conn, memberId);
		
		close(conn);
		
		return result;
	}

	
	/**	회원 가입 서비스
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int singUp(Member member) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.singUp(conn, member); // INSERT 수행
		
		// 트랜잭션 처리
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
}
