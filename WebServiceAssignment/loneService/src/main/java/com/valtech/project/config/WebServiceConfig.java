package com.valtech.project.config;


import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.project.loneService.*;
import com.valtech.project.services.LoanService;
import com.valtech.project.webservices.LoanServiceWSImpl;




@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint loanServiceWS(LoanService loanService) {
		EndpointImpl endpoint = new EndpointImpl(bus,new LoanServiceWSImpl(loanService));
		endpoint.setAddress("/loanService");
		endpoint.publish();
		return endpoint;

}
}

