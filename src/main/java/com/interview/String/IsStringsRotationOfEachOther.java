package com.interview.String;

public class IsStringsRotationOfEachOther {

	/*
	 * https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/
	 * https://www.geeksforgeeks.org/check-strings-rotations-not-set-2/
	 */

	/*
	 * 1. Create a temp string and store concatenation of str1 to str1 in temp. 
	 * 	  temp = str1.str1 
	 * 2. If str2 is a substring of temp then str1 and str2 are
	 * 	  rotations of each other.
	 * 
	 * 	  Example: str1 = "ABACD" str2 = "CDABA"
	 * 
	 * 	  temp = str1.str1 = "ABACDABACD" 
	 * 	  Since str2 is a substring of temp, str1 and str2 are rotations of each other.
	 */
	public static void main(String[] args) {

		String str1 = "ABCD";
		String str2 = "CDAB";

		boolean isRotation = isRotation(str1, str2);

		isRotation = (str1.length() == str2.length()) && ((str1 + str1).indexOf(str2) != -1);

		System.out.println("Both Strings " + (isRotation ? "are " : "are not ") + "rotation of each Other");
	}

	// KMP algorithm’s lps (longest proper prefix which is also suffix) construction
	public static boolean isRotation(String a, String b) {
		int n = a.length();
		int m = b.length();
		if (n != m)
			return false;

		// create lps[] that will hold the longest
		// prefix suffix values for pattern
		int lps[] = new int[n];

		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		// the loop calculates lps[i] for i = 1 to n-1
		while (i < n) {
			if (a.charAt(i) == b.charAt(len)) {
				lps[i] = ++len;
				++i;
			} else {
				if (len == 0) {
					lps[i] = 0;
					++i;
				} else {
					len = lps[len - 1];
				}
			}
		}

		i = 0;

		// match from that rotating point
		for (int k = lps[n - 1]; k < m; ++k) {
			if (b.charAt(k) != a.charAt(i++))
				return false;
		}
		return true;
	}

}
