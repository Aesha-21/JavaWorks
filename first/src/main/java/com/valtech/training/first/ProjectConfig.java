package com.valtech.training.first;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

//	@Bean
//	public SimpleInterface simpleintrest(Arithmetic arithmetic) {
//		return new SimpleInterestImpl(arithmetic);
//	}
//	@Bean
	public Arithmetic arith() {
		return new ArithmeticImpl();
	}
}
