package com.interview.Heap;

import java.util.Arrays;

public class DeleteMaxElementfromMaxHeap {

	
	public static void main(String[] args) {
		//int A[] = {1, 14, 10, 8, 7, 9, 3, 2, 4, 6};
		int A[] = {12, 20, 2, 13, 32, 50, 88, 21, 18, 91};
		System.out.println("Given input array is: "+ Arrays.toString(A));
		
		BuildMaxHeapfromArray.buildMaxHeap(A); // Using Existing method to build the Max heap from Array
		
		
		System.out.println("After Max Heapify array is: "+ Arrays.toString(A));
	}
	/*
	 * This method will return -1 in negative cases.
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
		
		return 1;
	}
}
