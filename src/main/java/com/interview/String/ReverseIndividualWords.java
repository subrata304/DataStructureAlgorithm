package com.interview.String;

import java.util.Stack;

public class ReverseIndividualWords {

	/*
	 * Time Complexity : O(N)
	 * Space Complexity: O(1)
	 */
	/*
	 * public static String reverseWords(String str) {
	 * 
	 * // Pointer to the first character // of the first word int start = 0; String
	 * resultStr = ""; StringBuilder sb = new StringBuilder(); for (int i = 0; i <
	 * str.length(); i++) {
	 * 
	 * // If the current word has ended if (str.charAt(i) == ' ' || i ==
	 * str.length()) {
	 * 
	 * // Pointer to the last character // of the current word int end = i - 1;
	 * 
	 * // Reverse the current word while (start < end) { resultStr = resultStr +
	 * str.charAt(end) + str.charAt(start); start++; end--; }
	 * 
	 * // Pointer to the first character // of the next word start = i + 1; } }
	 * 
	 * return resultStr; }
	 * 
	 * private static void swap(char charAt, char charAt2) {
	 * 
	 * 
	 * }
	 */
	
	/*
	 * Time Complexity: O(N)
	 * Space Complexity: O(N)
	 */
	private static void reverseWordsWithStack(String str) {
		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) != ' ')
				st.push(str.charAt(i));

			else {
				while (st.empty() == false) {
					System.out.print(st.pop());

				}
				System.out.print(" ");
			}
		}

		while (st.empty() == false) {
			System.out.print(st.pop());

		}
	}

	public static void main(String[] args) {

		String str = "Polygot Programmer";

		reverseWordsWithStack(str);
		
		System.out.println("");
		
		//System.out.println(reverseWords(str));

	}
}
