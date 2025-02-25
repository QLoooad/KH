package edu.kh.project.member.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service // Service Layer
		// 비즈니스 로직(데이터 가공, DAO호출, 트랜잭션 제어)
		// + Bean 등록하는 어노테이션
public class MemberServiceImpl implements MemberService{
	
	// @Autowired : 작성된 필드와
	// Bean으로 등록된 객체 중 타입이 일치하는 Bean을 
	// 해당 필드에 주입(Injection)하는 어노테이션
	// == DI(Dependency Injection, 의존성 주입)
	//	  -> 객체를 직접 만들지 않고 Spring이 만들걸 주입(Spring에 의존)
	@Autowired
	private MemberDAO dao;
	
	@Autowired // bean으로 등록된 객체 중 타입이 일치하는 
	private BCryptPasswordEncoder bcrypt;
	
	// org.slf4j.Logger; : 로그 작성 객체
	private Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
													// 로그를 얻고자 하는 클래스 명.class.
	@Override
	public Member login(Member inputMember) {
		
		// 로그 출력
		logger.info("MemberService.login() 실행"); // 정보 출력
		logger.debug("memberEmail : " + inputMember.getMemberEmail());
		logger.warn("경고");
		logger.error("에러");
		
		
		// 암호화 추가 예정
//		System.out.println("암호화 확인 : " + bcrypt.encode(inputMember.getMemberPw()));
		
		// bcrytp 암호화는 salt가 추가되기 때문에
		// 계속 비밀번호가 바뀌게 되어 DB에서 비교 불가
		// -> 별도로 제공해주는 metches(평문, 암호문)을 이용해 비교
		
		// dao 메서드 호출
		Member loginMember = dao.login(inputMember);
		
		if(loginMember != null) { // 아이디가 일치하는 회원이 조회된 경우
			
			// 입력한 PW, 암호화된 PW 같은지 확인 
			if(bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) {
				
				// 비밀번호를 유지하지 않기 위해서 로그인 정보에서 제거
				loginMember.setMemberPw(null);
				
			}else { // 다를 경우
				loginMember = null; // 로그인 실패처럼 만듦
				
			}
			
		}
		
		return loginMember;
	}

	
	
	// 회원 가입 서비스
	@Transactional(rollbackFor = {Exception.class})
	// 예외 발생 시 rollback
	// 발생 안하면 서비스 종료 시 commit
	
	@Override
	public int signUp(Member inputMember) {
		// 비밀번호를 BCrypt를 이용하여 암호화 후 다시 inputMember에 세팅
		String encPw = bcrypt.encode(inputMember.getMemberPw());
		inputMember.setMemberPw(encPw);
		
		// DAO 호출
		int result = dao.signUp(inputMember);
		
		return result;
	}
	
	

}
