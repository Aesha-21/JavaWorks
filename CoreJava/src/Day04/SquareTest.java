package Day04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {

	@Test
	void testSquareNow() {
		Square sq = new Square() {
			
//			public double squareNow(double x) {
//				// TODO Auto-generated method stub
//				return x*x;
//			}

			public double squareNow(double x) {
				// TODO Auto-generated method stub
				return x*x;
			}
		};
		
		Square square = (a) -> a * a;
		assertEquals(0, square.squareNow(0));
		assertEquals(0, square.squareNow(0));
		assertEquals(1, square.squareNow(-1));
		assertEquals(1, square.squareNow(1));

		
	}

}
