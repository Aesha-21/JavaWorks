package com.valtech.project.CustOrder.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

//	@GetMapping("/hello")
	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name","Aesha");
		List<String> lt = new ArrayList<String>();
		lt.add("ami");
		lt.add("heta");
		
		model.addAttribute("nm",lt);
		
		
		return "hello";
	}
	
	@RequestMapping("/home")
	public ModelAndView myhome() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("name","This is Demo of Model and View Example.");
		return modelView;
	}
}
