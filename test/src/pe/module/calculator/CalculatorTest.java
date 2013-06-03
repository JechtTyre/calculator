package pe.module.calculator;

import static org.junit.Assert.*;

import org.junit.Test;


public class CalculatorTest {
	CalculatorModel calculator = new CalculatorModel();
	@Test
	public void plus() {		
		
		assertEquals(8, calculator.plus(3,5));
		assertEquals(0.5, calculator.plus(0.2, 0.3), 0);
	}
	
	@Test
	public void minus() {
				
		assertEquals(-2, calculator.minus(3,5), 0);
		assertEquals(-2.5, calculator.minus(-5, -2.5), 0);
	}
	
	@Test
	public void mult() {
		assertEquals(15, calculator.mult(3,5));
	}
	
	@Test
	public void devide() {
		assertEquals(2, calculator.devide(6,3));
	}
	
	@Test
	public void calculateplus() {
		String postfix = calculator.changePostfix("1+2");
		int result = calculator.calculate(postfix);
		assertEquals(3, result);		
	}
	
	@Test
	public void calculateminus() {
		String postfix = calculator.changePostfix("2-1");
		int result = calculator.calculate(postfix);
		assertEquals(1, result);
		
		postfix = calculator.changePostfix("1-2");
		result = calculator.calculate(postfix);
		assertEquals(-1, result);
	}
	
	@Test
	public void calculatemultiple() {
		String postfix = calculator.changePostfix("2*4");
		int result = calculator.calculate(postfix);
		assertEquals(8, result);
	}
	
	@Test
	public void calculatdivide() {
		String postfix = calculator.changePostfix("4/2");
		int result = calculator.calculate(postfix);		
		assertEquals(2, result);
	}
	
	
	
	@Test
	public void changepostfixplus() {
		
		String changed = calculator.changePostfix("1+2");
		assertEquals("1 2 +", changed);	
	}
	
	@Test
	public void change10Numberpostfix() {
		String changed = calculator.changePostfix("10+20");
		assertEquals("10 20 +", changed);
	}
	
	@Test
	public void change3digitpostfix() {
		String changed = calculator.changePostfix("100+200");
		assertEquals("100 200 +", changed);
	}
	@Test
	public void changepostfixdoubleplus() {
		String changed = calculator.changePostfix("1+2+3");
		assertEquals("1 2 + 3 +", changed);		
	}
	
	@Test
	public void change2digitpostfixdoubleplus() {
		String changed = calculator.changePostfix("10+20+30");
		assertEquals("10 20 + 30 +", changed);		
	}
	@Test
	public void changepostfixminus() {
		
		String changed = calculator.changePostfix("1-2");
		assertEquals("1 2 -", changed);		
	}
	
	@Test
	public void changepostfixmultiple() {
		
		String changed = calculator.changePostfix("1*2");
		assertEquals("1 2 *", changed);		
	}
	
	@Test
	public void changepostfixdivide() {
		
		String changed = calculator.changePostfix("1/2");
		assertEquals("1 2 /", changed);		
	}
}