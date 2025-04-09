package com.valtech.project.QuizeService.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.project.QuizeService.vos.QuestionVO;


@Component
public class QuestionClient {

	public List<QuestionVO> getQuestionByTopic(String topic) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9030/api/v1/questions/topic/"+topic;
		List<QuestionVO> qvo = restTemplate.getForObject(url, List.class);
		return qvo;
	
	}
	
	public List<QuestionVO> getQuestionsOfQuize(Long quizId){
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9030/api/v1/questions/quiz/"+quizId;
		List<QuestionVO> qvo = restTemplate.getForObject(url, List.class);
		return qvo;
	}
	
	
	
	
}
