package pe.module.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CalculatorTest extends TestCalculatorPrj {
	
	CalculatorModel calculator = new CalculatorModel();
		
	private void assertCalculate(String modify, int result) {
		
		String postfix = calculator.changePostfix(modify);
		Number value = calculator.calculate(postfix);
		assertEquals(new Number(result), value);
	}
	@Test
	public void calculateplus() {
		
		assertCalculate("1+2", 3);
	}
	
	/*@Test
	public void calculateplus_002() {
		
		String postfix = calculator.changePostfix("1.0+2.0");
		int value = calculator.calculate(postfix);
		assertEquals(3.0, value, 0);
	}*/
	
	
	@Test
	public void calculate2digitNumberplus() {
		
		assertCalculate("10+20", 30);
	}
	
	@Test
	public void calculate2digitNumberplus_002() {
		assertCalculate("10+20+30", 60);
	}
	
	@Test
	public void calculate3digitdoubleNumberplus() {
		
		assertCalculate("100+200", 300);
	}
	
	@Test
	public void calculateminus() {
		
		assertCalculate("2-1", 1);
		assertCalculate("1-2", -1);
	}
	
	@Test
	public void calculatemultiple() {
		
		assertCalculate("2*4", 8);
	}
	
	@Test
	public void calculatdivide() {
		assertCalculate("4/2", 2);
	}
	
	private void assertPostfix(String normalfix, String postfix) {
		String changed = calculator.changePostfix(normalfix);
		assertEquals(postfix, changed);
	}
	@Test
	public void changepostfixplus() {
		assertPostfix("1+2", "1 2 +");
	}
	
	@Test
	public void changepostfixplus_002() {
		assertPostfix("1.0+2.0", "1.0 2.0 +");
	}
	
	@Test
	public void change10Numberpostfix() {
		assertPostfix("10+20", "10 20 +");
	}	
	
	@Test
	public void change3digitpostfix() {
		assertPostfix("100+200", "100 200 +");
	}
	
	@Test
	public void changepostfixdoubleplus() {
		assertPostfix("1+2+3", "1 2 + 3 +");
	}
	
	@Test
	public void change2digitpostfixdoubleplus() {
		assertPostfix("10+20+30", "10 20 + 30 +");
	}
	@Test
	public void changepostfixminus() {
		assertPostfix("1-2", "1 2 -");
	}
	
	@Test
	public void changepostfixmultiple() {
		assertPostfix("1*2", "1 2 *");
	}
	
	@Test
	public void changepostfixdivide() {
		assertPostfix("1/2", "1 2 /");
	}
}