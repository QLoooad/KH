package com.pingpong.project.manager.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pingpong.project.board.model.dto.Board;
import com.pingpong.project.member.model.dto.Member;

@Repository
public class ManagerDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 관리자 페이지 가입 회원 목록 조회
	 * @return memberList
	 */
	public List<Member> selectMemberList() {
		
		return sqlSession.selectList("managerMapper.selectMemberList");
	}

	/** 관리자 페이지 탈퇴 회원 목록 조회
	 * @return memberList
	 */
	public List<Member> selectSessionList() {
		
		return sqlSession.selectList("managerMapper.selectSecessionList");
	}

	/** 관리자 페이지 게시글 목록 조회
	 * @return boardList
	 */
	public List<Board> selectBoardList() {
		
		return sqlSession.selectList("managerMapper.selectBoardList");
	}
	
}
