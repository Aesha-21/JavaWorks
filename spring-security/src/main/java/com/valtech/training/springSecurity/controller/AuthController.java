package com.valtech.training.springSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.springSecurity.entities.User;
import com.valtech.training.springSecurity.service.UserManagerService;
import com.valtech.training.springSecurity.vos.ChangePasswordVO;
import com.valtech.training.springSecurity.vos.UserVO;

@Controller
public class AuthController {
	
	@Autowired
	private UserManagerService userService;
	
	@GetMapping("/changePassword")
	public String showChangePassword() {
		return "changePassword";
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@AuthenticationPrincipal User user,@ModelAttribute ChangePasswordVO chpwdVO) {
		userService.changePassword(user.getUsername(),chpwdVO);
		return "redirect:login";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute UserVO uvo) {
		userService.registerUSer(uvo.to());
		return "login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String user() {
		return "User";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "Admin";
	}

}
