package com.interview.Heap;

/*
 * Find and print the largest 3 elements from an unsorted array
 * 
 */

public class FindKthLargestElementFromArray {

	public static void main(String[] args) {
		
		int arr[] = {1, 23, 12, 9, 30, 2, 50};
		int k = 10;
	
		/*
		 * Steps:
		 * 1. Build a Max heap --> O(n) times
		 * 2. Use DeleteMaxElement k times to get k largest elements --> O(klogn)
		 * 
		 * Total Time Complexity: O(n + klogn)
		 * 
		 */
		if(k > arr.length) {
			System.out.println("Please provide valid kth value");
			return;
		}
		BuildMaxHeapfromArray.buildMaxHeap(arr, arr.length);
		//int size = arr.length;
		for(int i = 0; i < k ; i++) {
			int maxElement = DeleteMaxElementfromMaxHeap.deleteMaxElement(arr);
			//size--;
			//BuildMaxHeapfromArray.maxHeapify(arr, size, 0);
			System.out.println("The Max elements are: " + maxElement);
		}
		
	}
}
