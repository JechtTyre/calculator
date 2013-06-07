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
	
	private int result(char value, int first, int second) {
		
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
		
		return result.number;
	}
	
	private int getResult(char operator, Stack<Integer> NumberStack) {
		int second = NumberStack.pop();
		int first = NumberStack.pop();
		
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
	
	private int calculateIter(Stack<Integer> NumberStack, int result, int index, String postfixed) {
		
		if(index == postfixed.length()) {
			
			if(NumberStack.isEmpty() == false) {
				result = getResult(postfixed.charAt(index), NumberStack);
			}
			return result;
		}
		
		if(postfixed.charAt(index) == ' ') {
			NumberStack.push(result);
			result = 0;
		}
		
		else if(isNumber(postfixed.charAt(index))) {
			if(result > 0) {
				result *= 10;
			}
			
			result += Integer.parseInt(Character.toString(postfixed.charAt(index)));
		}
		else if(isOperator(postfixed.charAt(index))) {
			result = getResult(postfixed.charAt(index), NumberStack);						
		}
		
		return calculateIter(NumberStack, result, index + 1, postfixed);
	}
	
	int calculate(String postfixed) {
		
		Stack<Integer> NumberStack = new Stack<Integer>();
		
		return calculateIter(NumberStack, 0 ,0, postfixed);
	}
	
	String changePostfix(String value) {
		Stack<Character> OperatorStack = new Stack<Character>();
				
		return postfixIter(OperatorStack, 0, "", value);
	}
}
