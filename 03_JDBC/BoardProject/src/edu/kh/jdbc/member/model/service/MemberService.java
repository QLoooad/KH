package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	public List<Member> selectMemberList() throws SQLException {
		Connection conn = getConnection();
		
		List<Member> memberList = dao.selectMemberList(conn);
		
		close(conn);
		
		return memberList;
	}

	/**	회원 정보 수정 서비스
	 * @param memberName
	 * @param memberGender
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(String memberName, String memberGender, int memberNo) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, memberName, memberGender, memberNo);
		
		//트랜잭션 처리
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	/**	비밀번호 변경 서비스
	 * @param nowPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws SQLException
	 */
	public int updatePw(String nowPw, String newPw, int memberNo) throws SQLException {
		Connection conn = getConnection();
		
		int result = dao.updatePw(conn, nowPw, newPw, memberNo);
		
		//트랜잭션 처리
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}	
	
	/**	숫자 6자리 보안코드 생성 서비스
	 * @return code
	 */
	public String createSecurityCode() {
		
		StringBuffer code = new StringBuffer();
		
		// String :  불변성
		// StringBuffer : 가변성
		Random ran = new Random();
		
		for(int i = 0; i < 6; i++) {
			int x = ran.nextInt(10);// 0~9
			code.append(x); // 뒤에 이어 붙임
		}
		
		return code.toString();
		
	}

	public int unRegisterMember(String nowPw, int memberNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.unRegisterMember(conn, nowPw, memberNo);
		
		//트랜잭션 처리
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
}
