package com.valtech.training.leaveservice.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
class EmployeeClientTest {

	@Autowired
	EmployeeClient client;
	
	@Test
	void test() {
		assertEquals(3, client.getEmployeeAsManager(3));
	}

}
