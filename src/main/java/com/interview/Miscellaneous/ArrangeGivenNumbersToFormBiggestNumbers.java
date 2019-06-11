package com.interview.Miscellaneous;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * Given an array of numbers, arrange them in a way that yields the largest value. 
 * For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value. 
 * 
 */
public class ArrangeGivenNumbersToFormBiggestNumbers {

	// Method 1
	public static void printLargest(List<String> arr) {

		Collections.sort(arr, (X, Y) -> {

			String XY = X + Y;

			String YX = Y + X;

			return XY.compareTo(YX) > 0 ? -1 : 1;
		});

		Iterator<String> it = arr.iterator();

		while (it.hasNext())
			System.out.print(it.next());

	}

	// Method 2 :: https://www.geeksforgeeks.org/arrange-given-numbers-form-biggest-number-set-2/
	public static String largestNumber(List<Integer> arr) {
		// finding number of digits in maximum element
		// present in array
		int n = Collections.max(arr).toString().length();

		ArrayList<ExtendedNum> en = new ArrayList<ExtendedNum>();
		for (int i = 0; i < arr.size(); i++)
			en.add(new ExtendedNum(arr.get(i), n));

		// sort based on modified value
		Collections.sort(en, (p1, p2) -> (int) (p2.modifiedValue - p1.modifiedValue));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < en.size(); i++)
			sb.append(new StringBuilder(Long.toString(en.get(i).originalValue)));

		// To remove any zeroes at head.
		BigInteger bi = new BigInteger(sb.toString());

		return bi.toString();
	}

	static class ExtendedNum {
		int originalValue;
		long modifiedValue;

		public ExtendedNum(int originalValue, int n) {
			this.originalValue = originalValue;
			String s = Integer.toString(originalValue);
			StringBuilder sb = new StringBuilder(s);
			StringBuilder ans = new StringBuilder();
			while (ans.length() <= n + 1)
				ans.append(sb);

			s = ans.toString().substring(0, n + 1);
			modifiedValue = Long.parseLong(s);
		}

		public String toString() {
			return "[" + modifiedValue + ", " + originalValue + "]";
		}
	}

	public static void main(String[] args) {

		List<String> arr = new ArrayList<>();
		// output should be 6054854654
		arr.add("54");
		arr.add("546");
		arr.add("548");
		arr.add("60");
		printLargest(arr);
	}
}
