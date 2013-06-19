package pe.module.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberTest extends TestCalculatorPrj {
	
	@Test
	public void setNumberPlus() {
		Number five = new Number(5);
		Number ten = five.plus(new Number(5));
		
		assertEquals(new Number(10), ten);		
	}
	
	@Test
	public void setNumberMinus() {
		Number five = new Number(5);
		Number zero = five.minus(new Number(5));
		
		assertEquals(new Number(0), zero);		
	}
	
	@Test
	public void setNumberMultiple() {
		Number five = new Number(5);
		Number result = five.mult(new Number(5));
		
		assertEquals(new Number(25), result);		
	}
	
	@Test
	public void setNumberDevide() {
		Number ten = new Number(10);
		Number two = ten.devide(new Number(5));
		
		assertEquals(new Number(2), two);		
	}
}
