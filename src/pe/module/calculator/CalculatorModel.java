package pe.module.calculator;

import java.util.Stack;

class CalculatorModel {
	
	private boolean isOperator(char value) {
		
		if(value == '+' || value == '-' 
				|| value == '*' || value == '/') {
			return true;
		}
		
		return false;	
	}
	
	private boolean isNumber(char value) {
		if(value >= '0' && value <= '9') {
			return true;
		}
		
		return false;		
	}
	
	int devide(int a, int b) {
		return a / b;
	}
	
	int mult(int a, int b) {
		return a * b;
	}
	
	int minus(int a, int b) {
		return a - b;
	}
	double minus(int a, double b) {
		return a - b;
	}
	
	int plus(int a, int b) {
		return a + b;	
	}
	
	double plus(double a, double b) {
		return a + b;
	}
	
	private int result(char value, int first, int second) {
		
		int result = 0;
		
		if(value == '+') {
			result = plus(first, second);
		}
		else if(value == '-') {
			
			result = minus(first, second);
		}
		
		else if(value == '*') {
			result = mult(first, second);
		}
		
		else if(value == '/') {
			result = devide(first, second);
		}
		
		return result;
	}
	
	int calculate(String postfixed) {	
		
		int result = 0;
		Stack<Character> NumberStack = new Stack<Character>();
		
		for(int i = 0; i < postfixed.length(); i++) {
			if(isNumber(postfixed.charAt(i))) {
				NumberStack.push(postfixed.charAt(i));
			}
			else if(isOperator(postfixed.charAt(i))) {
				
				int second = Integer.valueOf(NumberStack.pop().toString());
				int first = Integer.valueOf(NumberStack.pop().toString());
				
				result = result(postfixed.charAt(i), first, second);				
			}
		}
		
		return result;
	}
	
	String Postfixiter(Stack<Character> OperatorStack, int index, String postfix, String normalfix) {
		
		if(index == normalfix.length()) return postfix;
		else if(isNumber(normalfix.charAt(index))) {
			postfix += normalfix.charAt(index);
			postfix += " ";
		}
		else if(isOperator(normalfix.charAt(index))) {
			if(OperatorStack.isEmpty() == false) {
				postfix += " " + OperatorStack.pop().toString() + " ";				
			}
			
			OperatorStack.push(normalfix.charAt(index));
		}
			
		return Postfixiter(OperatorStack, index + 1, postfix, normalfix);
	}
	String changePostfix(String value) {
		Stack<Character> OperatorStack = new Stack<Character>();
		String postfix = "";
		
		Character character;
		Character NextChar = null;
		for(int i = 0; i < value.length(); i++) {
			
			character = value.charAt(i);			
			
			if(isNumber(character)) {	
				
				if(i + 1 < value.length()) {
					NextChar = value.charAt(i + 1);
				} else {
					NextChar = null;
				}
				
				postfix += character;
				
				if(NextChar != null && isNumber(NextChar)) {					
					continue;					
				} else {
					postfix += " ";					
				}
			}
			
			if(isOperator(character) || i == value.length() -1) {
				
				if(OperatorStack.isEmpty() == false) {
					postfix += OperatorStack.pop().toString();
					
					if(i + 1 < value.length()) {
						postfix += " ";
					}
				}
				OperatorStack.push(character);
				
			}						
		}
		return postfix;// Postfixiter(OperatorStack, 0, postfix, value);
	}
}
