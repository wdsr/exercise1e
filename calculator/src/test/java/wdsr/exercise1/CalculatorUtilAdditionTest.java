package wdsr.exercise1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilAdditionTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}

	@Test
	public void test2plus2() {
		// given
		doReturn(4).when(calculator).add(anyInt(), anyInt());

		// when
		String result = calcUtil.getAdditionText(2, 2);

		// then
		assertEquals("2 + 2 = 4", result);
		verify(calculator).add(anyInt(), anyInt()); // check if our calculator mock was really invoked.
	}	
}
