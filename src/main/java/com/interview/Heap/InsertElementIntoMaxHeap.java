package com.interview.Heap;

import java.util.Arrays;

/*
 * Insert a new element into a Max Heap
 * 
 */

public class InsertElementIntoMaxHeap {

	public static void main(String[] args) {

		int A[] = { 91, 32, 88, 21, 20, 50, 2, 13, 18, 12 }; // Input Array is alreay a Max Heap
		System.out.println("Given input array is: " + Arrays.toString(A));
		
		int newElement = 89;
		
		inserElement(A, newElement);

	}

	/*
	 * Steps:
	 * 1. Increase the heap/array size
	 * 2. Keep the new element at the end of the heap or last index of the array
	 * 3. Heapify the element from bottom to top
	 * 
	 * Time Complexity: We need to travel from leaf node till root of the heap, so it is 
	 * equal to height of the tree i.e. O(log n)
	 */
	private static void inserElement(int[] A, int element) {
		
		int size = A.length;
		size++;
		A = Arrays.copyOf(A, size);
		A[size - 1] = element;
		
		int i = size - 1;
		
		while(i > 0 && A[getParentIndex(i)] < A[i] ) {
			int temp = A[i];
			A[i] = A[getParentIndex(i)];
			A[getParentIndex(i)] = temp;
			i = getParentIndex(i);
		}
		
		System.out.println("The new Max Heap is: " + Arrays.toString(A));

	}
	private static int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

}
