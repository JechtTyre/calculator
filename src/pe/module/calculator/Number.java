package pe.module.calculator;

public class Number {
	
	private int number = 0;
	
	public Number(int number) {
		this.number = number;
	}
	
	public Number(Number number) {
		this.number = number.number;
	}
	
	boolean morethan(Number compareNum) {
		return number > compareNum.number;
	}
	Number devide(Number b) {
		return new Number(this.number / b.number);
	}
	
	Number mult(Number b) {
		return new Number(this.number * b.number);
	}
	
	Number minus(Number b) {
		return new Number(this.number - b.number);
	}
	Number plus(Number b) {
		return new Number(this.number + b.number);	
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
