package com.interview.Array;

import java.util.Arrays;

import com.interview.Heap.BuildMinHeapfromArray;

public class NearlySortedArray {

	/*
	 * Sort a nearly sorted (or K sorted) array
   	 * Given an array of n elements, 
   	 * where each element is at most k away from its target position.
	 */
	
	public static void main(String[] args) {
		int arr[] = {10, 9, 8, 7, 4, 70, 60, 50};
		int k = 4;
		sortNearlySortedArray(arr, k);
	}

	private static void sortNearlySortedArray(int[] arr, int k) {
		
		/*
		 * It can sort using intertion sort where Time will be O(nk) as inner look needs to execute k times
		 * 
		 * Better approach is as below --> 
		 * 
		 * 1) Create a Min Heap of size k+1 with first k+1 elements. This will take O(k) time
		 * 2) One by one remove min element from heap, put it in result array, 
		 *    and add a new element to heap from remaining elements.
		 * Removing an element and adding a new element to min heap will take Logk time. 
		 * So overall complexity will be O(k) + O((n-k)*logK)
		 * Overall it takes: O(nLogk) time and uses O(k) auxiliary space.
		 */
		System.out.println("Actual nearly sorted array : "+Arrays.toString(arr));
		int length = arr.length;
		int[] heap = new int[k+1];
		for(int i=0; i <= k ; i++) {
			heap[i] = arr[i];
		}
		System.out.println("Array with K+1 elements to be Minheapify : "+ Arrays.toString(heap));
		BuildMinHeapfromArray.buildMinHeap(heap, heap.length);
		
		System.out.println("Min Heap with K+1 Elements :  "+Arrays.toString(heap));
		
		for(int i=k+1, index=0; index < length; index++, i++) {
			if(i < length) {
				arr[index] = replaceMinElementInHeap(heap, arr[i]);
			}else{
				arr[index] = deleteMinElement(heap);
			}
		}
		System.out.println("Final Sorted Array : "+ Arrays.toString(arr));
		
	}
	
	private static int replaceMinElementInHeap(int[] arr, int element) {
		int minElement = arr[0];
		arr[0] = element;
		BuildMinHeapfromArray.minHeapify(arr, 0);
		return minElement;
	}
	public static int deleteMinElement(int A[]){
		int size = A.length;
		if(size == 0){
			return -1;
		}else if(size == 1){
			return A[0];
		}
		int min = A[0];
		A[0] = A[size - 1];
		size--;
		BuildMinHeapfromArray.minHeapify(A, 0);
		return min;
	}
}
