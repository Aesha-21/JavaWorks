package com.valtech.training.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleInterestImpl implements SimpleInterface {

	@Autowired
	private Arithmetic arithmetic;

	@Override
	public int compute(int pris, int time, int rate) {
		// TODO Auto-generated method stub
		return arithmetic.div(arithmetic.mul(pris, arithmetic.mul(time, rate)),100);
	}
	
//	public SimpleInterestImpl(Arithmetic arithmetic) {
//		this.arithmetic = arithmetic;
//	}

//	@Override
//	public int compute(int pris,int time,int rate) {
//		
//		return arithmetic.div(arithmetic.mul(pris, arithmetic.mul(time, rate)),100);
//	}
	
//	public void setArithmetic(Arithmetic arithmetic) {
//		this.arithmetic = arithmetic;
//	}
}
