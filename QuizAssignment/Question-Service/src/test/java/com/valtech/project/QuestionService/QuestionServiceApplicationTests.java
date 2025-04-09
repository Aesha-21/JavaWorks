package com.valtech.project.QuestionService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.project.QuestionService.services.QuestionService;
import com.valtech.project.QuestionService.vos.QuestionVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuestionServiceApplicationTests {
	
	@LocalServerPort
	private int port;

	@Autowired
	TestRestTemplate restTemplate;
	@Autowired
   QuestionService questionService;
	
	@Test
	void testQuestions() {
		
		String baseurl = "http://localhost:"+port+"/api/v1/questions/";
		List lst = restTemplate.getForObject(baseurl, List.class);
		if(lst.size() == 0) {
			restTemplate.postForObject(baseurl, new QuestionVO(0L,"What is Java?", "C language", "C++", "OOP", "OOP","Java",1L), QuestionVO.class);
			restTemplate.postForObject(baseurl, new QuestionVO(0L,"Which langage is platform independent?", "C ", "C++", "Java", "java","Java",1L), QuestionVO.class);
			restTemplate.postForObject(baseurl, new QuestionVO(0L,"What is object in java?", "variable", "blueprint of class", "method", "blueprint of class","Java",1L), QuestionVO.class);
			restTemplate.postForObject(baseurl, new QuestionVO(0L,"What is method overloading?", "no of args & types of args", "return type diff", "not supporting", "no of args & types of args","Java",1L), QuestionVO.class);
			restTemplate.postForObject(baseurl, new QuestionVO(0L,"who use ORM ?", "spring", "Hibernate", "JAVA", "Hibernate","Java",1L), QuestionVO.class);

			restTemplate.postForObject(baseurl, new QuestionVO(0L,"What is Devops", "language", "method", "practice", "method","Devops",2L), QuestionVO.class);
			restTemplate.postForObject(baseurl, new QuestionVO(0L,"What is Jenkins?", "language", "ci/cd tool", "practice", "ci/cd tool","Devops",2L), QuestionVO.class);
			restTemplate.postForObject(baseurl, new QuestionVO(0L,"What is GIT?", "version control system", "tool", "practice", "version control system","Devops",2L), QuestionVO.class);
			restTemplate.postForObject(baseurl, new QuestionVO(0L,"What is GitHub", "collabrative work UI", "application", "practice", "collabrative work UI","Devops",2L), QuestionVO.class);
			restTemplate.postForObject(baseurl, new QuestionVO(0L,"What is Docker", "Containrization tool", "just a tool", "language", "Containrization tool","Devops",2L), QuestionVO.class);


		}
	}
	
	@Test
	void testallQuestions() {
		assertEquals(5, questionService.getQuestion(2));
	}

}
