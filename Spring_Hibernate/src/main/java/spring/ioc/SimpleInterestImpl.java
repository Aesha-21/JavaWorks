package spring.ioc;

public class SimpleInterestImpl implements SimpleInterface {

	private Arithmetic arithmetic;
	
	@Override
	public int compute(int pris,int time,int rate) {
		
		return arithmetic.div(arithmetic.mul(pris, arithmetic.mul(time, rate)),100);
	}
	
	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}
}
