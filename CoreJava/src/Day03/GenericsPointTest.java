package Day03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenericsPointTest {

	@Test
	void testInt() {
		//test when it's integer
		
		GenericsPoint<Integer> p = new GenericsPoint<Integer>();
		p.setX(3);
		p.setY(4);
		System.out.println(p);
	}
	
	@Test
	void testDouble() {
		//test when it's double
		
		GenericsPoint<Double> p = new GenericsPoint<Double>();
		p.setX(3D);
		p.setY(4D);
		System.out.println(p);
	}
	
	@Test
	void testString() {
		//test when it's double
		
		GenericsPoint<String> p = new GenericsPoint<String>();
		p.setX("a");
		p.setY("1");
		System.out.println(p);
	}

}
