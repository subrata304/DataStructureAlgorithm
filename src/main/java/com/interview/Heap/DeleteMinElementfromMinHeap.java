package com.interview.Heap;

import java.util.Arrays;


/*
 * Delete the min element from a existing Heap.
 */


public class DeleteMinElementfromMinHeap {

	public static void main(String[] args) {
		
		int A[] = {2, 13, 12, 18, 32, 50, 88, 21, 20, 91}; // Input Array is alreay a Min Heap
		System.out.println("Given input array is: "+ Arrays.toString(A));		
		
		int minElement = deleteMinElement(A);
		
		System.out.println("The Min Element is: "+ minElement);
		
	}
	/*
	 * This method will return -1 in negative cases.
	 * In case only one element is there in the Heap, It will return first element.
	 * 
	 * In case more than one element is there, 
	 * 1. It will first copy the root(first) element in some temp variable, 
	 * 2. Replace the root with last element of the heap/array
	 * 3. Call MinHeapify
	 * 
	 * Time Complexity of this algorithm is : O(log n), as we are calling minHeapify which needs Order of the height 
	 * i.e. O(log n), Space complexity also O(log n)
	 */
	protected static int deleteMinElement(int A[]){
		int size = A.length;
		if(size == 0){
			return -1;
		}else if(size == 1){
			return A[0];
		}
		int min = A[0];
		A[0] = A[size - 1];
		size--;
		A = Arrays.copyOf(A, size);
		BuildMinHeapfromArray.minHeapify(A, 0);
		System.out.println("After Min Heapify array is: "+ Arrays.toString(A));
		return min;
	}
}
