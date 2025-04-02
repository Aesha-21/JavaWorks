package com.valtech.training.leaveservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.leaveservice.vos.LeaveMasterVO;

import java.util.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LeaveMasterControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Test
	void createLeavseMasterTest() {
		String baseurl = "http://localhost:"+port+"/api/v1/leaveMasters/";
		List leaveMaster = restTemplate.getForObject(baseurl, List.class);
		if(leaveMaster.size() == 0) {
			restTemplate.postForObject(baseurl, new LeaveMasterVO(0, 10, 5, 2, 1), LeaveMasterVO.class);
			restTemplate.postForObject(baseurl, new LeaveMasterVO(0, 5, 5, 2, 2), LeaveMasterVO.class);
			restTemplate.postForObject(baseurl, new LeaveMasterVO(0, 6, 5, 2, 1), LeaveMasterVO.class);
			restTemplate.postForObject(baseurl, new LeaveMasterVO(0, 9, 7, 2, 1), LeaveMasterVO.class);
			restTemplate.postForObject(baseurl, new LeaveMasterVO(0, 10, 8, 2, 1), LeaveMasterVO.class);

		}
	}

}
