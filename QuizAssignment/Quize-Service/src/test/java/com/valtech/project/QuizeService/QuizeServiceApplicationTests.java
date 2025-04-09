package com.valtech.project.QuizeService;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.project.QuizeService.vos.QuizeVO;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuizeServiceApplicationTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	void testQuize() {
		String baseurl = "http://localhost:"+port+"/api/v1/quizes/";
		List lst = restTemplate.getForObject(baseurl, List.class);
		if(lst.size() == 0) {
			restTemplate.postForObject(baseurl, new QuizeVO(0L, 5, 5, 0,"Java") , QuizeVO.class);
		}
	}

}
