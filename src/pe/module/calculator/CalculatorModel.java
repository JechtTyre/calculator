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
	
	private Number result(char value, Number first, Number second) {
		
		Number result = null;
		Number nfirst = new Number(first);
		
		if(value == '+') {
			result = nfirst.plus(second);
		}
		else if(value == '-') {
			
			result = nfirst.minus(second);
		}
		
		else if(value == '*') {
			result = nfirst.mult(second);
		}
		
		else if(value == '/') {
			result = nfirst.devide(second);
		}
		
		return result;
	}
	
	private Number getResult(char operator, Stack<Number> NumberStack) {
		Number second = NumberStack.pop();
		Number first = NumberStack.pop();
		
		return result(operator, first, second);
	}
	
	private String postfixIter(Stack<Character> OperatorStack, int index, String postfix, String value) {		
		
		if(index == value.length()) {
			if(OperatorStack.isEmpty() == false) {
				if(postfix.charAt(postfix.length() - 1) != ' ') {
					postfix += " ";
				} 
				
				postfix += OperatorStack.pop().toString();
			}
			
			return postfix;
		}
		
		if(isOperator(value.charAt(index))) {
			postfix += " ";
			if(OperatorStack.isEmpty() == false) {
				postfix += OperatorStack.pop().toString() + " ";				
			}
			OperatorStack.push(value.charAt(index));			
		} 
		else if(isNumber(value.charAt(index))){
			postfix += value.charAt(index);
		} else if(value.charAt(index) == '.') {
			postfix += value.charAt(index);
		}
		
		return postfixIter(OperatorStack, index + 1, postfix, value);		
	}
	
	private Number calculateIter(Stack<Number> NumberStack, Number result, int index, String postfixed) {
		
		if(index == postfixed.length()) {
			
			if(NumberStack.isEmpty() == false) {
				result = getResult(postfixed.charAt(index), NumberStack);
			}
			return result;
		}
		
		if(postfixed.charAt(index) == ' ') {
			NumberStack.push(result);
			result = new Number(0);
		}
		
		else if(isNumber(postfixed.charAt(index))) {
						
			if(result.morethan(new Number(0))) {
				result = result.mult(new Number(10));
			}
			
			int parseInt = Integer.parseInt(Character.toString(postfixed.charAt(index)));
			result = result.plus(new Number(parseInt));
		}
		else if(isOperator(postfixed.charAt(index))) {
			result = getResult(postfixed.charAt(index), NumberStack);						
		}
		
		return calculateIter(NumberStack, result, index + 1, postfixed);
	}
	
	Number calculate(String postfixed) {
		
		Stack<Number> NumberStack = new Stack<Number>();
		
		return calculateIter(NumberStack, new Number(0) ,0, postfixed);
	}
	
	String changePostfix(String value) {
		Stack<Character> OperatorStack = new Stack<Character>();
				
		return postfixIter(OperatorStack, 0, "", value);
	}
}
