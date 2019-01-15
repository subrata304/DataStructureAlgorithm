package com.interview.Heap;

import java.util.Arrays;


/*
 * Given an array Build a Min Heap from the same.
 */

public class BuildMinHeapfromArray {

	public static void main(String[] args) {
		//int A[] = {1, 14, 10, 8, 7, 9, 3, 2, 4, 6};
		int A[] = {12, 20, 2, 13, 32, 50, 88, 21, 18, 91};
		System.out.println("Given input array is: "+ Arrays.toString(A));
		buildMinHeap(A, A.length);
		System.out.println("After Min Heapify array is: "+ Arrays.toString(A));
	}
	
	protected static void buildMinHeap(int[] A, int size){
		for(int i = size/2 - 1 ; i>=0 ;i--){
			minHeapify(A, i);
		}
	}
	
	protected static void minHeapify(int[] A, int i){
		int left = 2*i + 1;
		int right = 2*i + 2;
		int smallest;
		
		if(left < A.length && A[left] < A[i]){
			smallest = left;
		}else{
			smallest = i;
		}
		if(right < A.length && A[right] < A[smallest]){
			smallest = right;
		}
		if(smallest != i){
			int temp = A[smallest];
			A[smallest] = A[i];
			A[i] = temp;
			System.out.println("Before calling recursion: "+ Arrays.toString(A));
			minHeapify(A, smallest);
		}		
	}
}