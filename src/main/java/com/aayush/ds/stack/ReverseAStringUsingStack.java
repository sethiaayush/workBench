package com.aayush.ds.stack;

import java.util.Stack;

public class ReverseAStringUsingStack {

	public static String reverse(String S) {
		Stack<Character> characterStack = new Stack<>();

		for (int i = 0; i < S.length(); i++) {
			characterStack.add(S.charAt(i));
		}

		StringBuilder toReturn = new StringBuilder();
		while (!characterStack.empty()) {
			toReturn.append(characterStack.pop());
		}

		return toReturn.toString();
	}

	public static void main(String[] args) {
		System.out.println(reverse("GeeksforGeeks"));
	}

}
