package com.valtech.project.QuestionService.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.project.QuestionService.services.QuestionService;
import com.valtech.project.QuestionService.vos.QuestionVO;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/{id}")
	public QuestionVO getQuestion(@PathVariable("id") int id) {
		return questionService.getQuestion(id);
	}
	@GetMapping("/")
	public List<QuestionVO> getAllQuestions(){
		return questionService.getAllQuetions();
	}
	
	@PostMapping("/")
	public QuestionVO createQuestion(@RequestBody QuestionVO qvo) {
		return questionService.saveQuestion(qvo);
	}
	
	@PutMapping("/{id}")
	public QuestionVO updateQuestion(@PathVariable("id") int id, @RequestBody QuestionVO qvo) {
		return questionService.update(id, qvo);
	}
	
	@GetMapping("/topic/{topic}")
	public List<QuestionVO> getQuestionByTopic(@PathVariable("topic") String topic){
		return questionService.getQuestionByTopic(topic);
	}
	
	@GetMapping("/quiz/{quizId}")
	public List<QuestionVO> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId){
		
		return questionService.getQuestionsOfQuiz(quizId);
	}
	
	@GetMapping("/ques/{ids}")
	public List<QuestionVO> getQueById(@PathVariable("ids") String ids){
		List<Integer> id = Arrays.stream(ids.split(",")).map(Integer::parseInt).collect(Collectors.toList());
		return questionService.getQueByListOfIds(id);
	}

}
