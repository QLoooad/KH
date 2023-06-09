package edu.kh.project.myPage.model.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.common.utility.Util;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.dao.MyPageMapper;

@Service // 비즈니스 로직 처리 클래스 + Bean 등록 (IOC)
@PropertySource("classpath:/config.properties") // properties 파일 내용을 현재 클래스에서 사용
public class MyPageServiceImpl implements MyPageService{

	@Value("${my.member.webpath}")
	private String webPath;
	
	@Value("${my.member.location}")
	private String filePath;
	
	@Autowired
	private MyPageMapper mapper;
	
	@Autowired // BCryptPasswordEncoder 의존성 주입(DI)
	private BCryptPasswordEncoder bcrypt;
	
	// 회원 정보 수정 서비스
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int updateInfo(Member updateMember) {
		return mapper.updateInfo(updateMember);
	}

	
	
	@Transactional(rollbackFor = Exception.class) 
	// 모든 Exception 발생 시 rollback
	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {
		
		// 1. 현재 비밀번호, DB에 저장된 비밀번호 비교
		// 1) 회원번호가 일치하는 MEMBER 테이블 행의 MEMBER_PW 조회
		String encPw = mapper.selectEncPw(memberNo);
		
		// 2) bcrypt.matches(평문, 암호문) -> 같으면 true -> 이 때 비번 수정
		if(bcrypt.matches(currentPw, encPw)) {
			
			Member member = new Member();
			member.setMemberNo(memberNo);
			member.setMemberPw(bcrypt.encode(newPw));
			
			// 2. 비밀번호 변경(UPDATE DAO 호출) -> 결과 반환
			return mapper.changePw(member);
		}
		
		// 3) 비밀번호가 일치하지 않으면 0 반환
		return 0;
	}


	// 회원 탈퇴 서비스
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int secession(String memberPw, int memberNo) {
		
		// 1. 회원 번호가 일치하는 회원의 비밀번호 조회
		String encPw = mapper.selectEncPw(memberNo);
		
		// 2.비밀번호가 일치하면 
		if(bcrypt.matches(memberPw, encPw)) {
			// MEMBER_DEL_FL -> 'Y'로 바꾸고 1 반환
			return mapper.secession(memberNo);
		}
		
		//  3. 비밀번호가 일치하지 않으면 -> 0 반환
		return 0;
	}

	
	// 프로필 이미지 수정 서비스
	@Override
	public int updateProfile(MultipartFile profileImage, Member loginMember) throws IllegalStateException, IOException {

		// 프로필 이미지 변경 실패 대비
		String temp = loginMember.getProfileImage(); // 이전 이미지 저장
		
		String rename = null; // 변경 이름 저장 변수
		
		if(profileImage.getSize() > 0) {// 업로드된 이미지가 있을 경우
			
			// 1) 파일 이름 변경
			rename = Util.fileRename(profileImage.getOriginalFilename());
			
			// 2) 바뀐 이름 loginMember에 세팅
			loginMember.setProfileImage(webPath + rename); 
			
		}else {// 없는 경우 (x버튼)
			loginMember.setProfileImage(null);
			// 세션 이미지를 null로 변경해서 삭제
		}
		
		// 프로필 이미지 수정 DAO 호출
		
		int result = mapper.updateProfileImage(loginMember);
		
		if(result > 0) { // 성공
			
			// 새 이미지가 업로드된 경우
			if(rename != null) {
				profileImage.transferTo(new File(filePath + rename));
			}
			
		}else { // 실패
			// 이전 이미지로 프로필 다시 세팅
			loginMember.setProfileImage(temp);
			
		}
		return result;
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
