package com.valtech.training.restApis.controllers;

import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
	
//	@RequestMapping(method = RequestMethod.GET,path = "/hello")
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name,@RequestParam("time") int time) {
		String res ="";
		for(int i =0;i<time;i++) {
			res+=name;
		}
		return "hello"+res;
	}

}
