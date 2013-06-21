package pe.module.calculator;

public class MyInteger {
	
	private Integer number = 0;
	
	public MyInteger(int number) {
		this.number = number;
	}
	
	public MyInteger(MyInteger number) {
		this.number = number.number;
	}
	
	boolean morethan(MyInteger compareNum) {
		return number > compareNum.number;
	}
	MyInteger devide(MyInteger b) {
		return new MyInteger(this.number / b.number);
	}
	
	MyInteger mult(MyInteger b) {
		return new MyInteger(this.number * b.number);
	}
	
	MyInteger minus(MyInteger b) {
		return new MyInteger(this.number - b.number);
	}
	MyInteger plus(MyInteger b) {
		return new MyInteger(this.number + b.number);	
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return this.number.equals(((MyInteger)obj).number);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(this.number); 
	}
}
