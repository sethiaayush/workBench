package com.aayush.ds.stack;

import java.util.Stack;

public class GetMinimumElementFromStack {

	int minEle;
	Stack<Integer> s = new Stack<Integer>();

	/* returns min element from stack */
	int getMin() {
		recalculateMinAndCheckStack();

		return minEle;
	}

	/* returns poped element from stack */
	int pop() {
		if (s.empty()) {
			return -1;
		}
		int poppedInt = s.pop();
		recalculateMinAndCheckStack();
		return poppedInt;
	}

	/* push element x into the stack */
	void push(int x) {
		if (s.empty()) {
			s = new Stack<Integer>();
			minEle =  x;
		}
		s.push(x);
		recalculateMinAndCheckStack();
	}
	
	void recalculateMinAndCheckStack() {
		
		Stack<Integer> stackToCheckMinValue = (Stack<Integer>) s.clone();
		minEle = Integer.MAX_VALUE;
		while (!stackToCheckMinValue.empty()) {
			minEle = Math.min(minEle, stackToCheckMinValue.pop());
		}
		
		if(s.empty()) {
			minEle = -1;
		}
	}

	public static void main(String[] args) {
		GetMinimumElementFromStack stack = new GetMinimumElementFromStack();
		stack.push(79);
		System.out.println(stack.getMin());
		stack.push(4);
		System.out.println(stack.getMin());
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		stack.push(61);
		System.out.println(stack.getMin());
		
	}
}
