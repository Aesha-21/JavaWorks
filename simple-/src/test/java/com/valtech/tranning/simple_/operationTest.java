package com.valtech.tranning.simple_;

import junit.framework.TestCase;

public class operationTest extends TestCase {
	
//	operation pluse = (a,b) -> a+b;
//	operation minus = (a,b) -> a-b;
//	operation div = (a,b) -> a/b;

	
	public void testApp() {
	
		assertEquals(3,operation.pluse.perform(2, 1));
		
		
	}

}
