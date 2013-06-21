package pe.module.calculator;

public class MyDouble {

	private Double number;
	
	@Override
	public boolean equals(Object obj) {
		
		return this.number.equals(((MyDouble)obj).number);
	}

	public MyDouble(double d) {
		number = d;
	}
	
	public MyDouble plus(MyDouble d) {
		return new MyDouble(this.number + d.number);		
	}
	
	@Override
	public String toString() {
		
		return String.valueOf(this.number);
	}

	public MyDouble minus(MyDouble d) {
		// TODO Auto-generated method stub
		return new MyDouble(this.number - d.number);
	}

	public MyDouble mult(MyDouble d) {
		// TODO Auto-generated method stub
		return new MyDouble(this.number * d.number);
	}

	public MyDouble devide(MyDouble d) {
		// TODO Auto-generated method stub
		return new MyDouble(this.number / d.number);
	}



}
