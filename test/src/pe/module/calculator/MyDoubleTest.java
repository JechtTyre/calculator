package pe.module.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyDoubleTest extends TestCalculatorPrj {
	
	@Test
	public void setNumberPlus() {
		MyDouble five = new MyDouble(5.0);
		MyDouble ten = five.plus(new MyDouble(5.0));
		
		assertEquals(new MyDouble(10.0), ten);		
	}
	
	@Test
	public void setNumberMinus() {
		MyDouble five = new MyDouble(5.0);
		MyDouble zero = five.minus(new MyDouble(5.0));
		
		assertEquals(new MyDouble(0), zero);		
	}
	
	@Test
	public void setNumberMultiple() {
		MyDouble five = new MyDouble(5);
		MyDouble result = five.mult(new MyDouble(5));
		
		assertEquals(new MyDouble(25), result);		
	}
	
	@Test
	public void setNumberDevide() {
		MyDouble ten = new MyDouble(10);
		MyDouble two = ten.devide(new MyDouble(5));
		
		assertEquals(new MyDouble(2), two);		
	}

}
