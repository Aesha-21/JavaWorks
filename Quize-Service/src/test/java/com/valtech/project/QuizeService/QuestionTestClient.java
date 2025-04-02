package com.valtech.project.QuizeService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.project.QuizeService.services.QuestionClient;
@SpringBootTest
class QuestionTestClient {

	@Autowired
	QuestionClient client;
	
	@Test
	void test() {
//		assertEquals(3, client.getQuestionByTopic("java").size());
		System.out.println(client.getQuestionByTopic("java"));
		System.out.println("------------...............................>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		System.out.println(client.getQuestionsOfQuize(2L));
	}

}
