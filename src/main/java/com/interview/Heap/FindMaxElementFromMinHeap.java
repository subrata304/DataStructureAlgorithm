package com.interview.Heap;

import java.util.Arrays;

/*
 * Find the Max element from a Given Min Heap
 */

public class FindMaxElementFromMinHeap {

	public static void main(String[] args) {
		int A[] = { 2, 13, 12, 18, 32, 50, 88, 21, 20, 91 }; // Input Array is alreay a Min Heap
		System.out.println("Given input array is: " + Arrays.toString(A));

		int maxElement = findMaxElement(A);

		System.out.println("The Max Element is: " + maxElement);
	}
	/*
	 * The Max element in a Min heap will always be in leaf nodes.
	 * As leaf nodes start from (n/2+1)th till n where n = no of total nodes.
	 * We have to search in that range only.
	 * 
	 * Time Complexity is: O(n/2) == O(n)
	 */
	private static int findMaxElement(int[] arr) {
		
		int max = -1;
		for(int i = arr.length/2 + 1 ; i < arr.length ; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

}
