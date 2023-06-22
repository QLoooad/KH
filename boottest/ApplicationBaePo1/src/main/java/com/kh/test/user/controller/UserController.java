package com.kh.test.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.user.model.service.UserService;
import com.kh.test.user.model.vo.User;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/searchFail")
	public String searchFail() {
		return "/searchFail";
	}
	
	@GetMapping("/searchSuccess")
	public String searchSuccess(User user, Model model) {
		
//		List<User> userList = service.userFind(user);
		User userList = service.userFind(user);
		
//		System.out.println(userList.getUserNo());
//		System.out.println(userList.getUserId());
//		System.out.println(userList.getUserName());
//		System.out.println(userList.getUserAge());
		
		String path = "/";
		
		if(userList != null) {
//		if(userList.size() != 0) {
			path += "searchSuccess";
			model.addAttribute("userList", userList);
		}else {
			path += "searchFail";
		}
		
		return path;
	}
	
}