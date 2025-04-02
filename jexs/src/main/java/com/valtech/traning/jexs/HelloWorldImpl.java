package com.valtech.traning.jexs;

import javax.jws.WebService;

@WebService(endpointInterface = "com.valtech.traning.jexs.HelloWorld",
name="HelloWorld",portName = "HelloWorldPort")
public class HelloWorldImpl implements HelloWorld {
	
	public String hello(String name) {
		return "Hello"+name+"This is a Jax ws project";
	}

}
