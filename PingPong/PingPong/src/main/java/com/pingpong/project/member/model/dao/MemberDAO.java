package com.pingpong.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pingpong.project.member.model.dto.Member;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public Member login(Member inputMember) {
		return sqlSession.selectOne("memberMapper.login", inputMember);
	}

	public int signup(Member inputMember) {
		// 1) mapper의 namespace를 지정 후
		// 그 안에 어떤 id를 가지는 sql 수행할지 작성

		// 2) sql에 사용할 데이터를 전달 (Type(자료형) 중요)
//			return sqlSession.insert("1) namespace.id", 2) inputMember);

		// insert 성공한 행의 개수 반환
		return sqlSession.insert("memberMapper.signup", inputMember);
	}

}