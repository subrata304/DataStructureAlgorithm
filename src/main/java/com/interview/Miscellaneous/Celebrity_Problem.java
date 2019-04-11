package com.interview.Miscellaneous;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/the-celebrity-problem/
 */

public class Celebrity_Problem {

	// Person with 2 is celebrity
	static int MATRIX[][] = { 
								{ 0, 0, 1, 0 }, 
								{ 0, 0, 1, 0 }, 
								{ 0, 0, 0, 0 }, 
								{ 0, 0, 1, 0 } 
							};

	// Returns true if a knows
	// b, false otherwise
	public static boolean knows(int a, int b) {
		boolean res = (MATRIX[a][b] == 1) ? true : false;
		return res;
	}

	// Approach 1: Using Stack
	
	// Returns -1 if celebrity
	// is not present. If present,
	// returns id (value from 0 to n-1).
	public static int findCelebrity(int n) {
		Stack<Integer> st = new Stack<>();
		int c;

		// Step 1 :Push everybody
		// onto stack
		for (int i = 0; i < n; i++) {
			st.push(i);
		}

		while (st.size() > 1) {
			// Step 2 :Pop off top
			// two persons from the
			// stack, discard one
			// person based on return
			// status of knows(A, B).
			int a = st.pop();
			int b = st.pop();

			// Step 3 : Push the
			// remained person onto stack.
			if (knows(a, b)) {
				st.push(b);
			}

			else
				st.push(a);
		}

		c = st.pop();

		// Step 5 : Check if the last
		// person is celebrity or not
		for (int i = 0; i < n; i++) {
			// If any person doesn't
			// know 'c' or 'a' doesn't
			// know any person, return -1
			if (i != c && (knows(c, i) || !knows(i, c)))
				return -1;
		}
		return c;
	}

	
	//Approach 2: Using Two Pointers
	
	public static int findCelebrityWithoutExtraSpace(int n) {

		int a = 0;
		int b = n - 1;

		// Keep moving while
		// the two pointers
		// don't become same.
		while (a < b) {
			if (knows(a, b))
				a++;
			else
				b--;
		}

		// Check if a is actually
		// a celebrity or not
		for (int i = 0; i < n; i++) {
			// If any person doesn't
			// know 'a' or 'a' doesn't
			// know any person, return -1
			if (i != a && (knows(a, i) || !knows(i, a)))
				return -1;
		}
		return a;
	}

	public static void main(String[] args) {
		int n = 4;
		int result = findCelebrityWithoutExtraSpace(n);
		if (result == -1) {
			System.out.println("No Celebrity");
		} else
			System.out.println("Celebrity ID " + result);
	}

}
