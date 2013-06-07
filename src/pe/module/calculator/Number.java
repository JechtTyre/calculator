package pe.module.calculator;

public class Number {
	
	public int number = 0;
	
	public Number(int number) {
		this.number = number;
	}
	
	Number devide(int b) {
		return new Number(this.number / b);
	}
	
	Number mult(int b) {
		return new Number(this.number * b);
	}
	
	Number minus(int b) {
		return new Number(this.number - b);
	}
	Number plus(int b) {
		return new Number(this.number + b);	
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return this.number == ((Number)obj).number;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(this.number); 
	}
}
