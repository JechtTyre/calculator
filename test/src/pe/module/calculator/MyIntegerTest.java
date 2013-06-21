package pe.module.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyIntegerTest extends TestCalculatorPrj {
	
	@Test
	public void setNumberPlus() {
		MyInteger five = new MyInteger(5);
		MyInteger ten = five.plus(new MyInteger(5));
		
		assertEquals(new MyInteger(10), ten);		
	}
	
	@Test
	public void setNumberMinus() {
		MyInteger five = new MyInteger(5);
		MyInteger zero = five.minus(new MyInteger(5));
		
		assertEquals(new MyInteger(0), zero);		
	}
	
	@Test
	public void setNumberMultiple() {
		MyInteger five = new MyInteger(5);
		MyInteger result = five.mult(new MyInteger(5));
		
		assertEquals(new MyInteger(25), result);		
	}
	
	@Test
	public void setNumberDevide() {
		MyInteger ten = new MyInteger(10);
		MyInteger two = ten.devide(new MyInteger(5));
		
		assertEquals(new MyInteger(2), two);		
	}
}
