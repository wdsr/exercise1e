package wdsr.exercise1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

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
		doReturn(4.0).when(calculator).divide(8, 2);
		
		// when
		String result = calcUtil.getDivisionText(8, 2);
		
		// then
		verify(calculator).divide(8,  2);
		assertThat(result, is(equalTo("8 / 2 = 4.0")));
		
		// when
		calcUtil.getDivisionText(3, 0);
		
		// then
		// empty - exception expected
	}
}
