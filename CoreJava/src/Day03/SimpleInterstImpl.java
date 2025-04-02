package Day03;

public class SimpleInterstImpl implements SimpleIntrest{
	public static void main(String[] args) {
		SimpleIntrest si = new SimpleInterstImpl();
		System.out.println(si.ComputeInetrest(20, 40, 9));
		
		SimpleIntrest si1 = new SimpleIntrest() {
			@Override
			public double ComputeInetrest(double principal, double rateOfIntrest, double duration) {
				// TODO Auto-generated method stub
				return SimpleIntrest.super.ComputeInetrest(principal, rateOfIntrest, duration);
			}
		};
		System.out.println(si.ComputeInetrest(20, 40, 9));

	}

}
