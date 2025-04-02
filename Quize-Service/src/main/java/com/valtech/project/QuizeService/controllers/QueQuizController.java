package com.valtech.project.QuizeService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.valtech.project.QuizeService.services.QueQuizService;
import com.valtech.project.QuizeService.vos.QuestionVO;
import com.valtech.project.QuizeService.vos.QuizeVO;

@Controller
public class QueQuizController {
	
	@Autowired
	private QueQuizService qqService;
	
	@GetMapping("/{quizId}")
	public  List<QuestionVO> getAllQuize(@PathVariable("quizId") long quizId) {
		return qqService.addQuestionsToQuiz(quizId);
	}

}
