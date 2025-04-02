package mocks;

public class SimpleInterestImpl implements SimpleInterest {

	private Arithmetic arithmetic;
	
	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic =arithmetic;
	}
	
	public int compute(int prin,int rate,int time) {
		int prod = arithmetic.mul(prin, rate);
		prod =arithmetic.mul(prod, rate);
		return arithmetic.div(rate, 100);
	}
}
