package com.valtech.tranning.simpleInterest;
import com.valtech.tranning.arithmetic.operation;

public class simpleInterest {
	
	public int compute(int pr,int rate,int time) {
		int pro = operation.pluse.perform(pr*rate, time);
		return pro;
	}
	

}
