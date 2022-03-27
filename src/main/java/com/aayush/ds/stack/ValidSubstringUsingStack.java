package com.aayush.ds.stack;

import java.util.Stack;

public class ValidSubstringUsingStack {

	public static void main(String[] args) {
		// System.out.println(findMaxLen("(()("));
		// System.out.println(findMaxLen("()(())("));
		// System.out.println(findMaxLen("()"));
		System.out.println(findMaxLen("))()(()"));

	}

	static int findMaxLen(String S) {
		int n = S.length();

		// Create a stack and push -1
		// as initial index to it.
		Stack<Integer> stk = new Stack<>();
		stk.push(-1);

		// Initialize result
		int result = 0;

		// Traverse all characters of given string
		for (int i = 0; i < n; i++) {
			// If opening bracket, push index of it
			if (S.charAt(i) == '(')
				stk.push(i);

			// // If closing bracket, i.e.,str[i] = ')'
			else {
				// Pop the previous
				// opening bracket's index
				if (!stk.empty())
					stk.pop();

				// Check if this length
				// formed with base of
				// current valid substring
				// is more than max
				// so far
				if (!stk.empty())
					result = Math.max(result, i - stk.peek());

				// If stack is empty. push
				// current index as base
				// for next valid substring (if any)
				else
					stk.push(i);
			}
		}

		return result;
	}
}
