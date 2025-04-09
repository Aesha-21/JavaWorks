package com.valtech.project.QuizeService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.project.QuizeService.services.QuizeService;
import com.valtech.project.QuizeService.vos.QuizeVO;




@RestController
@RequestMapping("/api/v1/quizes")
public class QuizeController {
	
	@Autowired
	private QuizeService quizeService;
	
	@GetMapping("/{id}")
	public QuizeVO getQuize(@PathVariable long id) {
		return quizeService.getQuiz(id);
	}
	
	@GetMapping("/")
	public List<QuizeVO> getAllQuize(){
		return quizeService.getAllQuiz();
	}
	
	@PostMapping("/")
	public QuizeVO createQuize(@RequestBody QuizeVO qvo) {
		return quizeService.saveQuiz(qvo);
	}
	
	@PutMapping("/{id}")
	public QuizeVO updateQuize(@PathVariable long id,@RequestBody QuizeVO qvo) {
		return quizeService.updateQuiz(id, qvo);
	}
}
