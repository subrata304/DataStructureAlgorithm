package com.interview.Array;

import java.util.Stack;

public class FindNextGreaterElementForEachElement {

	public static void printNextGreaterElement(int arr[], int n) {
		int i = 0;
		Stack<Integer> s = new Stack<>();

		int element, next;

		s.push(arr[0]);

		for (i = 1; i < n; i++) {
			next = arr[i];

			if (s.isEmpty() == false) {

				// if stack is not empty, then
				// pop an element from stack
				element = s.pop();

				/*
				 * If the popped element is smaller than next, then a) print the pair b) keep
				 * popping while elements are smaller and stack is not empty
				 */
				while (element < next) {
					System.out.println(element + " --> " + next);
					if (s.isEmpty() == true)
						break;
					element = s.pop();
				}

				/*
				 * If element is greater than next, then push the element back
				 */
				if (element > next)
					s.push(element);
			}

			/*
			 * push next to stack so that we can find next greater for it
			 */
			s.push(next);
		}

		/*
		 * After iterating over the loop, the remaining elements in stack do not have
		 * the next greater element, so print -1 for them
		 */
		while (s.isEmpty() == false) {
			element = s.pop();
			next = -1;
			System.out.println(element + " -- " + next);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 13, 7, 6, 12 };
		printNextGreaterElement(arr, arr.length);
	}
}
