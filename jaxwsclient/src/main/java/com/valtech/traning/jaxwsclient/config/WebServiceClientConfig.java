package com.valtech.traning.jaxwsclient.config;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.traning.jexs.HelloWorld;
import com.valtech.traning.jexs.webservices.MovieServiceWS;

@Configuration
public class WebServiceClientConfig {
	
	@Bean
	public MovieServiceWS createMovieService() {
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(MovieServiceWS.class);
		proxy.setServiceName(new QName("http://webservices.jexs.traning.valtech.com/","MovieServiceWsImplService"));
		proxy.setAddress("http://localhost:8080/services/movieService");
		
		return proxy.create(MovieServiceWS.class);
	}
	
	@Bean
	public HelloWorld createHelloWorldService() {
		System.out.println("Loading Hello World ...");
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(HelloWorld.class);
		proxy.setServiceName(new QName("http://jexs.traning.valtech.com/", "HelloWorldImplService"));
		proxy.setAddress("http://localhost:8080/services/helloWorld");

		return proxy.create(HelloWorld.class);

	}

}
