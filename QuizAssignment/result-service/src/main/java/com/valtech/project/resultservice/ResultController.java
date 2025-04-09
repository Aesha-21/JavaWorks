package com.valtech.project.resultservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.project.services.ResultService;
import com.valtech.project.vos.ResultVO;


@RestController
@RequestMapping("/api/v1/results")
public class ResultController {

	@Autowired
	private ResultService resultService;
	
	@GetMapping("/{quizId}")
	public ResultVO getQuizResult(@PathVariable("quizId")int quizId) {
		return resultService.testResults(quizId);
	}
}
