package edu.kh.project.member.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/member/logout")
public class LogoutController extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// HttpSession을 얻어와
		HttpSession session = req.getSession();
		
		// Session을 무효화 하고 
		session.invalidate();
		
		//메인페이지 재요청
		resp.sendRedirect("/");
	
	}
	
}
