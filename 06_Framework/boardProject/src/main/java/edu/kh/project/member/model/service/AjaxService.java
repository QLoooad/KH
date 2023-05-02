package edu.kh.project.member.model.service;

public interface AjaxService {

	/** 이메일로 닉네임 조회
	 * @param email
	 * @return
	 */
	String selectNickname(String email);

	/** 닉네임으로 전화번호 조회
	 * @param nickname
	 * @return
	 */
	String selectMemberTel(String nickname);

	int checkEmail(String email);

	int checkNickname(String nickname);

}
