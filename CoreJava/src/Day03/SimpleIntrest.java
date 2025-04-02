package Day03;

public interface SimpleIntrest {
	
	default double ComputeInetrest(double principal, double rateOfIntrest, double duration) {
		return principal * rateOfIntrest * duration /100;
	}
}
