package com.aayush.string;

public class CheckForSubSequence {

	public static void main(String[] args) {
		System.out.println(isSubSequence("AXY", "YADXCP"));
		System.out.println(isSubSequence("gksrek", "geeksforgeeks"));
	}

	static boolean isSubSequence(String A, String B) {
		String afterSingleCharString = B;
		for (char singleChar : A.toCharArray()) {
			if (afterSingleCharString.indexOf(singleChar) < 0) {
				return false;
			}
			afterSingleCharString = afterSingleCharString.substring(afterSingleCharString.indexOf(singleChar) + 1);
		}
		return true;

	}

}
