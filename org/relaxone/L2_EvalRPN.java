package org.relaxone;

import java.util.Stack;

public class L2_EvalRPN {
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				int op1 = stack.pop();
				int op2 = stack.pop();
				stack.push(op1 + op2);
			} else if (tokens[i].equals("-")) {
				int op1 = stack.pop();
				int op2 = stack.pop();
				stack.push(op2 - op1);
			} else if (tokens[i].equals("*")) {
				int op1 = stack.pop();
				int op2 = stack.pop();
				stack.push(op1 * op2);
			} else if (tokens[i].equals("/")) {
				int op1 = stack.pop();
				int op2 = stack.pop();
				stack.push(op2 / op1);
			} else {
				int temp = Integer.valueOf(tokens[i]).intValue();
				stack.push(temp);
			}
		}
		return stack.peek();
	}

	public static void main(String[] args) {
		L2_EvalRPN evalRPN = new L2_EvalRPN();
		String[] tokens = { "4", "13", "5", "/", "+" };
		System.out.println(evalRPN.evalRPN(tokens));
	}
}
