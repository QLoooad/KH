package edu.kh.project.member.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // Persistence Layer, 영속성 관련 클래스
//				(파일, DB 관련 클래스) + Bean 등록(== spring이 객체로 만들어둠)
public class MemberDAO {

	@Autowired
	private MemberMapper memberMapper; // MemberMapper 인터페이스를 상속 받은 자식 객체
										// -> 자식 객체가 SqlSessionTemplate 이용

	/**
	 * 로그인 DAO
	 * @param inputMember
	 * @return 회원정보 or null
	 */
	public Member login(Member inputMember) {

		// return sqlSession.selectOne("memberMapper.login", inputMember);
		return memberMapper.login(inputMember);
	}

	/**
	 * 회원 가입 DAO
	 * @param inputMember
	 * @return result
	 */
	public int signUp(Member inputMember) {
		return memberMapper.signUp(inputMember);
	}

}