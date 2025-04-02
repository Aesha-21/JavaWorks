package com.valtech.training.springweb.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.training.springweb.vos.LoginVO;

@Controller
public class HelloController {
	
	public ModelAndView test() {
		int x =0;
		ModelAndView view = new ModelAndView("login");
		view.addObject("message","Pls use Login Dialog");
		return view;
	}
	
	@PostMapping("/login")
	public String handleLoginForm(@ModelAttribute LoginVO login,Model model) {
		if("kemmy".equals(login.getUsername())&&("qwerty".equals(login.getPassword()))) {
			model.addAttribute("login", login);
			return "dashboard";
		}
		model.addAttribute("message","Invalid username and password");
		return "login";
		
	}
	
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/hello")
//	@ResponseBody
//	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

}
