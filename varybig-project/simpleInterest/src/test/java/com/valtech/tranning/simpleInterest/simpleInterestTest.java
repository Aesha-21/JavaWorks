package com.valtech.tranning.simpleInterest;

import junit.framework.TestCase;

public class simpleInterestTest extends TestCase {
	
	public void testsimpleInt() {
	simpleInterest si = new simpleInterest();
	assertEquals(500, si.compute(500, 20,30));
	}
}
