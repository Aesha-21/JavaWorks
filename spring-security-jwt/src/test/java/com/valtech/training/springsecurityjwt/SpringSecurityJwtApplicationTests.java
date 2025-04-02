package com.valtech.training.springsecurityjwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.RequestBuilder;

import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
class SpringSecurityJwtApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@WithAnonymousUser
	void testHelloAnonymous() throws Exception{
		System.out.println("This is from Test Anonymous................");
		mockMvc.perform(get("/hello")).andDo(print())
		.andExpect(content().string("Hello"))
		.andExpect(status().isOk());
		
	}
	

	@Test
	@WithAnonymousUser
	void testDataWithValidUser() throws Exception{
		
		mockMvc.perform(get("/data")).andDo(print())
		.andExpect(status().isUnauthorized());
	}
	
	
	
	@Test
	@WithMockUser(roles="USER")
	void testDataWithAnyValidUser() throws Exception{
		mockMvc.perform(get("/data")).andDo(print())
		.andExpect(content().string("Data"))
		.andExpect(status().isOk());
	}

	
	
	
	
	
	
	
}
