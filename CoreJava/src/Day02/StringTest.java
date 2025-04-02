package Day02;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

class StringTest {

	@Test
	void test() {
		String s ="Hello";
		String s1 = "Hello";
		assertSame(s, s1);
		String s2 = new String("Hello");
		assertNotEquals(s1,s2);
		String s3 = "Hell"+"o";
		assertSame(s, s3);
		String s4 = "Hel";
		String s5 = "lo"+s4;
		assertNotEquals(s4, s5);
		////final String = s5+"o";
	}

}
