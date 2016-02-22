package wdsr.exercise1;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilModuloTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}

	@Test
	public void testModuloByZero() {
		fail("Not yet implemented");
	}	
}
