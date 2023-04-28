package edu.kh.project.myPage.model.service;

import edu.kh.project.member.model.dto.Member;

public interface MyPageService {

	/** 회원 정보 업데이트 서비스
	 * @param updateMember
	 * @return
	 */
	int updateInfo(Member updateMember);

}
