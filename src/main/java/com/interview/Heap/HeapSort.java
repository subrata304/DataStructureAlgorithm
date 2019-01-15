package com.interview.Heap;

import java.util.Arrays;

public class HeapSort {

	/*
	 * Sort an unsorted array in ascending order
	 */

	public static void main(String[] args) {

		int[] arr = { 4, 10, 3, 5, 1 };
		
		heapSort(arr);
	}
	/*
	 * Steps:
	 * 1. Build Max Heap
	 * 2. Delete the root name and put last node in root position.
	 * 3. maxiHeapify from root top to bottom (now the heap size = old heap size - 1) 
	 * 4. Repeat step 2. and step 3 till all nodes are covered.
	 * 
	 * Time Complexity: O(nlogn) -> As Build [Max Heap(O(n)) + (N -1) times Heapify (n -1)* O (logn)] ==> O(n logn)
	 * Space Complexity: O(1)
	 */
	private static void heapSort(int[] arr) {
		
		int size = arr.length;
		
		BuildMaxHeapfromArray.buildMaxHeap(arr, size);

		for(int i = size -1 ; i> 0; i--) {
			
			int maxElement = arr[0];
			arr[0] = arr[i];
			arr[i] = maxElement;
			
			BuildMaxHeapfromArray.maxHeapify(arr, i, 0);
		}
		System.out.println("After Sorting the Array is: "+ Arrays.toString(arr));
	}
}
