package Day02;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class Oprations implements Arithmetic {
	
	

	@Override
	public double subtract() {
		// TODO Auto-generated method stub
		return a-b;
		
	}

	@Override
	public double add() {
		
		return a+b;
		// TODO Auto-generated method stub
		
	}

	@Override
	public double multiply() {
		
		return a*b;
		// TODO Auto-generated method stub
		
	}

	public int div(int a, int b) {
		
		// TODO Auto-generated method stub
		return a/b;
	}
	
	

}
