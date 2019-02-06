package com.interview.SortingAlgo;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = {7, 2, 4, 1, 5, 3};
		System.out.println("Before Sorting the array is: "+ Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("After Sorting the array is: "+ Arrays.toString(arr));
	}

	/*
	 * Best Case(Already Sorted) :  O(n)
	 * Worst Case(Reverse Sorted) : O(n2) - Here for each ith iteration while loop will be executed i shift.
	 * Average Case: O(n2)
	 */
	private static void insertionSort(int[] arr) {
		int length = arr.length;
		int value;
		int hole;
		for(int i= 1; i< (length -1); i++) {
			value = arr[i];
			hole = i;
			while(hole > 0 && arr[hole - 1] > value) {
				arr[hole] = arr[hole - 1];
				hole--;
			}
			arr[hole] = value;
		}
	}
}
