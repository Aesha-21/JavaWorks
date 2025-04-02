package com.valtech.traning.jaxwsclient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.traning.jexs.HelloWorld;
import com.valtech.traning.jexs.Movie;
import com.valtech.traning.jexs.webservices.MovieServiceWS;

@SpringBootTest
class JaxwsclientApplicationTests {
	
	@Autowired
	private MovieServiceWS movieServiceWS;
	
	@Autowired
	private HelloWorld helloWorld;

	@Test
	void contextLoads() {
		System.out.println(helloWorld.hello("Valtech Mobility"));
		movieServiceWS.createMovie(new Movie("Inside Age", "English", "Comedy", List.of("abc","xyz")));
		System.out.println(movieServiceWS.getAllMovie());
	}

}
