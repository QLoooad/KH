package edu.kh.project.member.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;


@WebServlet("/member/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			req.setCharacterEncoding("UTF-8");
			
			String inputEmail = req.getParameter("inputEmail");
			String inputPw = req.getParameter("inputPw");
			
			MemberService service = new MemberService();
			
			// 로그인 서비스 호출 후 결과 반환 받기
			Member loginMember = service.login(inputEmail,inputPw);
			
			HttpSession session = req.getSession();
			
			if(loginMember != null) {// 로그인 성공
				
				// session 에 로그인한 회원 정보 추가
				session.setAttribute("loginMember", loginMember);
				
				// session 만료 시간 지정(초 단위)
				session.setMaxInactiveInterval(86400); // 테스트 후 1시간으로 변경
				
				// forward : 요청 처리 후 자체적 화면 존재 시 이용 후 응답
				// redirect : 요청 허리 후 자체적 화면이 없기에 
				//				화면이 있는 다른 요청을 다시 호출(요청)
				
				// ***** 요청 주소(주소창에 적는 주소) 작성 *****
				resp.sendRedirect("/"); // 메인 페이지 재요청
				
			}else {// 실패
				
				// 로그인 실패 메시지를 session에 추가
				session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
				
				// 현재 요청 이전 페이지로 redirect
				String referer = req.getHeader("referer");
				
				resp.sendRedirect(referer);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
