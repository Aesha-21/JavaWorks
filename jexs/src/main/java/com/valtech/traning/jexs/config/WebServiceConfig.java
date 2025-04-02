package com.valtech.traning.jexs.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.traning.jexs.HelloWorldImpl;
import com.valtech.traning.jexs.services.MovieService;
import com.valtech.traning.jexs.webservices.MovieServiceWsImpl;

@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint movieServiceWS(MovieService movieService) {
		EndpointImpl endpoint = new EndpointImpl(bus,new MovieServiceWsImpl(movieService));
		endpoint.setAddress("/movieService");
		endpoint.publish();
		return endpoint;
		
	}

	@Bean
	public Endpoint helloWorldWebService() {
		EndpointImpl endPoint = new EndpointImpl(bus, new HelloWorldImpl());
		endPoint.setAddress("/helloWorld");
		endPoint.publish();
		return endPoint;
	}
}
