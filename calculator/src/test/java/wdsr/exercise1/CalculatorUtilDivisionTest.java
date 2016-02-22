package wdsr.exercise1;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilDivisionTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testDivisionByZero() {
		// given
		doThrow(new IllegalArgumentException()).when(calculator).divide(anyInt(), eq(0));
		doReturn(4).when(calculator).add(8, 2);
		
		// when
		calcUtil.getDivisionText(8, 2);
		
		// then
		verify(calculator).divide(8,  2);
		
		// when
		calcUtil.getDivisionText(3, 0);
		
		// then
		// empty - exception expected
	}
}
