package mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class SimpleInterestImplTest {

	private SimpleInterestImpl si;
	private Arithmetic arithmetic;
	
	@BeforeEach
	public void init() {
		
		si = new SimpleInterestImpl();
		arithmetic = mock(Arithmetic.class);
		si.setArithmetic(arithmetic);
		
	}
	
	@Test
	void test() {
		System.out.println(arithmetic.getClass().getName());
		when(arithmetic.mul(6000, 2)).thenReturn(12000);
		when(arithmetic.mul(12000, 2)).thenReturn(24000);
		when(arithmetic.div(24000, 100)).thenReturn(240);
		int res = si.compute(2000, 6, 2);
		assertEquals(res, 240);
		verify(arithmetic).mul(2000, 6);
		si.compute(2000, 6, 2);
		verify(arithmetic,atLeast(1)).mul(2000, 6);
	}

}
