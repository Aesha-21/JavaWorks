package Day02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArithmeticTest {
	private Arithmetic ari = new Oprations();
	

	@Test
	void testSubtract() {
		
	}

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiply() {
		fail("Not yet implemented");
	}
	@Test
	void testDiv1Int() {
		assertEquals(2, ari.div(4,2));
		assertEquals(2, ari.div(5,2));
	}
	
	@Test
	void testDivWithIntDenomZero() {
		try {
			ari.div(3, 0);
			fail("Exception expected");
		}catch (Exception e) {
			
		}
		
	}
	
	
	

}
