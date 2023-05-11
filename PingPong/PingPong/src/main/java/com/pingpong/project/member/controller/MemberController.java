package com.pingpong.project.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pingpong.project.member.model.dto.Member;
import com.pingpong.project.member.model.service.MemberService;

@Controller
@RequestMapping("/member")
@SessionAttributes({ "loginMember" })
public class MemberController {

	@Autowired
	private MemberService service;

	// 로그인 전용 화면 이동
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}


	@PostMapping("/login")
	public String login(Member inputMember, Model model, @RequestHeader(value = "referer") String referer,
			@RequestParam(value = "saveId", required = false) String saveId, HttpServletResponse resp,
			RedirectAttributes ra) {
		System.out.println(inputMember.getMemberEmail());

		Member loginMember = service.login(inputMember);

		System.out.println(loginMember.getMemberNickname());

		String path = "redirect:";

		if (loginMember != null) {
			path += "/";

			model.addAttribute("loginMember", loginMember);

			Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());

			if (saveId != null) {
				cookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				cookie.setMaxAge(0);
			}
			cookie.setPath("/");
			resp.addCookie(cookie);
		} else {
			path += referer;
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		return path;
	}

	@GetMapping("/logout")
	public String logout(SessionStatus status, HttpSession session) {
		status.setComplete();
		return "redirect:/";
	}

	// 회원 가입 첫번째 페이지로 이동
	@GetMapping("/signup")
	public String signup() {
		return "member/signup";
	}
	
	// 회원 가입 두번째 페이지로 이동
	@GetMapping("/signupInfo")
	public String signupInfo() {

		return "member/signupInfo";
	}

	// 회원 가입 진행
	@PostMapping("/signup")
	public String signup(Member inputMember, RedirectAttributes ra, Model model) {

		// -------- 매개 변수 설명 ---------
		// Member inputMember : 커멘드 객체 (제출된 파라미터가 필드에 저장된 객체)
		// RedirectAttributes ra : 리다이렉트 시 데이터를 request scope로 전달하는 객체


		// 가입 성공 여부에 따라 주소 변경
		String path = "redirect:";
		String message = null;
		
		
		// 회원 가입 서비스 호출
		// DB에 DML 수행 시 성공 행의 개수 (int형) 반환

		int result = service.signup(inputMember);
		model.addAttribute("memberEmail", );
		if (result > 0) {
			path += "/"; // 메인페이지

			message = inputMember.getMemberNickname() + "님의 가입을 환영합니다.";

		} else {
//				path += "/member/signUp"; // 절대 경로
			path += "signup"; // 상대 경로
			message = "회원 가입 실패";
		}
		// 리다이렉트 시 session에 잠깐 올라갔다 내려오도록 세팅
		ra.addFlashAttribute("message", message);

		return path;
	}

}