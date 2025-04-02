package com.valtech.training.employee.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.employee.vos.EmployeeVO;

import java.util.List;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {
	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void addEmployee() {
		List emps = restTemplate.getForObject("http://localhost:"+port+"/api/v1/employees/", List.class);
		if(emps.size() == 0) {
			System.out.println("Adding employee");
			EmployeeVO manager = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",
					new EmployeeVO(0, "Aesha", 76454544, "aesha@gmail.com", 1),EmployeeVO.class);
			
			EmployeeVO manager1 = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",
					new EmployeeVO(1, "Ami", 345345345, "ami@gmail.com", manager.id()),EmployeeVO.class);
			
			EmployeeVO emp1 = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",
					new EmployeeVO(0, "Heta", 453454545, "heta@gmail.com", manager.id()),EmployeeVO.class);
			
			EmployeeVO emp2 = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",
					new EmployeeVO(0, "Kemmy", 76454544, "kemmy@gmail.com", manager.id()),EmployeeVO.class);
			
			EmployeeVO emp3 = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",
					new EmployeeVO(0, "Jasy", 76454544, "jasy@gmail.com", manager.id()),EmployeeVO.class);
			

		}

		
	}

}
