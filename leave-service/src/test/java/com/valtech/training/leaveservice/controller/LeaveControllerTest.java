package com.valtech.training.leaveservice.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.leaveservice.comans.LeaveStatus;
import com.valtech.training.leaveservice.comans.LeaveType;
import com.valtech.training.leaveservice.vos.ApproveLeaveVO;
import com.valtech.training.leaveservice.vos.LeaveVO;

import java.util.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LeaveControllerTest {

	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test  //errors check this
	void testApplyAndApprove() {
		String url = "http://localhost:"+port+"/api/v1/leaves";
		LeaveVO vo = restTemplate.postForObject(url+"apply", new LeaveVO(34, "23-02-2025", "25-02-2025", LeaveType.CASUAL.name(), LeaveStatus.APPLIED.name(), "", "", 7), LeaveVO.class);
		assertTrue(vo.id() !=0);
		assertEquals(vo.leaveStatus(), LeaveStatus.APPLIED);
		ApproveLeaveVO avo = new ApproveLeaveVO(vo.id(), "leave is approved",3);
		vo = restTemplate.postForObject(url+"approved", avo, LeaveVO.class);
		assertEquals(vo.leaveStatus(), LeaveStatus.APPROVED.name());
	}
	
	
	
	@Test
	void test() {
		String url = "http://localhost:"+port+"/api/v1/leaves/";
		List leave = restTemplate.getForObject(url,List.class);
		if(leave.size() == 0) {
			restTemplate.postForObject(url, new LeaveVO(0,"01-02-2025","22-01-2025",
					LeaveType.CASUAL.name(),LeaveStatus.APPLIED.name(),"asdsd","",2), LeaveVO.class);
			restTemplate.postForObject(url, new LeaveVO(0,"01-02-2025","22-01-2025",
					LeaveType.SICK.name(),LeaveStatus.APPLIED.name(),"asdsd","",2), LeaveVO.class);
			
			

		}
	}

}
