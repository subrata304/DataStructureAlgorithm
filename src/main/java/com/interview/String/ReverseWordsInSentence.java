package com.interview.String;

public class ReverseWordsInSentence {

	public static String wordReverse(String str) {
		int i = str.length() - 1;
		int start, end = i + 1;
		String result = "";

		while (i >= 0) {
			if (str.charAt(i) == ' ') {
				start = i + 1;
				while (start != end)
					result += str.charAt(start++);

				result += ' ';

				end = i;
			}
			i--;
		}

		start = 0;
		while (start != end)
			result += str.charAt(start++);

		return result;
	}

	public static void main(String[] args) {
		String str = "I am a Developer";

		System.out.print(wordReverse(str));
	}
}
