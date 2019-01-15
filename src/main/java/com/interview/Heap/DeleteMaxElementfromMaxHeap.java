package com.interview.Heap;

import java.util.Arrays;


/*
 * Delete the max element from a existing Heap.
 */


public class DeleteMaxElementfromMaxHeap {

	public static void main(String[] args) {
		
		int A[] = {91, 32, 88, 21, 20, 50, 2, 13, 18, 12}; // Input Array is alreay a Max Heap
		System.out.println("Given input array is: "+ Arrays.toString(A));		
		
		int maxElement = deleteMaxElement(A);
		
		System.out.println("The Max Element is: "+ maxElement);
		
	}
	/*
	 * This method will return -1 in negative cases.
	 * In case only one element is there in the Heap, It will return first element.
	 * 
	 * In case more than one element is there, 
	 * 1. It will first copy the root(first) element in some temp variable, 
	 * 2. Replace the root with last element of the heap/array
	 * 3. Call MaxHeapify
	 * 
	 * Time Complexity of this algorithm is : O(logn), as we are calling maxHeapify which needs Order of the height 
	 * i.e. O(log n), Space complexity also O(log n)
	 * 
	 */
	protected static int deleteMaxElement(int A[]){
		int size = A.length;
		if(size == 0){
			return -1;
		}else if(size == 1){
			return A[0];
		}
		int max = A[0];
		A[0] = A[size - 1];
		size--;
		A = Arrays.copyOf(A, size);
		BuildMaxHeapfromArray.maxHeapify(A, size, 0);
		System.out.println("After Max Heapify array is: "+ Arrays.toString(A));
		return max;
	}
}
