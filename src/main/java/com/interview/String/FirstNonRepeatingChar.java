package com.interview.String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNonRepeatingChar {

	public final static int MAX_CHAR = 26;

	public static void firstNonRepeatingChar(String str) {
		// count array of size 26(assuming
		// only lower case characters are present)
		int[] charCount = new int[MAX_CHAR];

		Queue<Character> q = new LinkedList<Character>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			q.add(ch);

			charCount[ch - 'a']++;

			while (!q.isEmpty()) {
				if (charCount[q.peek() - 'a'] > 1)
					q.remove();
				else {
					System.out.print(q.peek() + " ");
					break;
				}
			}
			if (q.isEmpty())
				System.out.print(-1 + " ");
		}
		System.out.println();
	}

	// Second Approach - Using Doubly Linked List

	public static void findFirstNonRepeating() {
		final int MAX_CHAR = 256;
		// inDLL[x] contains pointer to a DLL node if x is present
		// in DLL. If x is not present, then inDLL[x] is NULL
		List<Character> inDLL = new ArrayList<Character>();

		// repeated[x] is true if x is repeated two or more times.
		// If x is not seen so far or x is seen only once. then
		// repeated[x] is false
		boolean[] repeated = new boolean[MAX_CHAR];

		// Let us consider following stream and see the process
		String stream = "geeksforgeeksandgeeksquizfor";
		for (int i = 0; i < stream.length(); i++) {
			char x = stream.charAt(i);
			System.out.println("Reading " + x + " from stream n");

			// We process this character only if it has not occurred
			// or occurred only once. repeated[x] is true if x is
			// repeated twice or more.s
			if (!repeated[x]) {
				// If the character is not in DLL, then add this at
				// the end of DLL.
				if (!(inDLL.contains(x))) {
					inDLL.add(x);
				} else // Otherwise remove this character from DLL
				{
					inDLL.remove((Character) x);
					repeated[x] = true; // Also mark it as repeated
				}
			}

			// Print the current first non-repeating character from
			// stream
			if (inDLL.size() != 0) {
				System.out.print("First non-repeating character so far is ");
				System.out.println(inDLL.get(0));
			}
		}
	}

	public static void main(String[] args) {
		String str = "geeksforgeeksandgeeksquizfor";
		firstNonRepeatingChar(str);
		findFirstNonRepeating();
	}
}
