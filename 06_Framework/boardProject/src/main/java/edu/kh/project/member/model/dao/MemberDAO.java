package edu.kh.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // Persistence Layer, 영속성 관련 클래스
//				(파일, DB 관련 클래스) + Bean 등록(== spring이 객체로 만들어둠)
public class MemberDAO {

	// SQLSessionTemplate (마이바티스 객체) DI 
	@Autowired // 등록된 Bean 중에서 SQLSessionTemplate 타입의 Bean을 주입
	private SqlSessionTemplate sqlSession;
	
	
	/** 로그인 DAO
	 * @param inputMember
	 * @return 회원정보 or null
	 */
	public Member login(Member inputMember) {
		
		// 마이바티스를 이용해서 1행 조회(selectOne)
		// sqlSession.selectOne("namespace값.id값",전달할 값);
		// -> namespace가 일치하는 매퍼에서
		// 		id가 일치하는 sql구문을 수행 수
		// 		결과를 2행(dti, 기본 자료형)반환
		
		
		return sqlSession.selectOne("memberMapper.login", inputMember);
	}

}
