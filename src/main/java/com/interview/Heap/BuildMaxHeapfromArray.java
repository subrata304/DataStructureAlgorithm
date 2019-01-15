package com.interview.Heap;

import java.util.Arrays;


/*
 * Given an array Build a Max Heap from the same.
 */

public class BuildMaxHeapfromArray {

	public static void main(String[] args) {
		//int A[] = {1, 14, 10, 8, 7, 9, 3, 2, 4, 6};
		int A[] = {12, 20, 2, 13, 32, 50, 88, 21, 18, 91};
		System.out.println("Given input array is: "+ Arrays.toString(A));
		buildMaxHeap(A, A.length);
		System.out.println("After Max Heapify array is: "+ Arrays.toString(A));
	}

	protected static void buildMaxHeap(int[] A, int size){
		for(int i = size/2 -1 ; i>=0 ;i--){
			maxHeapify(A, size, i);
		}
	}
	/*
	 * A is the Heap, n is the size of the heap, i 
	 */
	protected static void maxHeapify(int[] A, int size, int i){
		int left = 2*i + 1;
		int right = 2*i + 2;
		int largest;
				
		if(left < size && A[left] > A[i]){
			largest = left;
		}else{
			largest = i;
		}
		if(right < size && A[right] > A[largest]){
			largest = right;
		}
		if(largest != i){
			int temp = A[largest];
			A[largest] = A[i];
			A[i] = temp;
			System.out.println("Before calling recursion: "+ Arrays.toString(A));
			maxHeapify(A, size, largest);
		}
	}
}