package com.interview.Array;

/*
 * https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
 */

public class MaxLengthOfUnsortedSubArrayToMakeCompleteArraySorted {

	private static void findUnsortedSubArray(int[] arr, int length) {
		int start = 0;
		int end = length - 1;
		int i, max, min;

		// Find index from beggining after which we get element less than that
		for (start = 0; start < length - 1; start++) {
			if (arr[start] > arr[start + 1])
				break;
		}
		if (start == length - 1) {
			System.out.println("The whole array is sorted");
			return;
		}

		// Find index of the element from end which is bigger than next one
		for (end = length - 1; end > 0; end--) {
			if (arr[end] < arr[end - 1])
				break;
		}

		max = arr[start];
		min = arr[start];

		// Find the max and min element from the array in given range start and end
		for (i = start + 1; i <= end; i++) {
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}
		// Find the element from 0 till Start which is greater than Min and change start
		// to that position.
		for (i = 0; i < start; i++) {
			if (arr[i] > min) {
				start = i;
				break;
			}
		}
		// FInd the element from end+1 till array length which is smaller than Max and
		// change the end to that position.
		for (i = length - 1; i >= end + 1; i--) {
			if (arr[i] < max) {
				end = i;
				break;
			}
		}

		System.out.println("The unsorted subarray which makes " + "the whole array sorted are from " + start + " : "
				+ arr[start] + " to " + end + " : " + arr[end]);
	}

	public static void main(String[] args) {
		// int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 50, 35, 60};
		int arr[] = { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60 };
		int length = arr.length;
		findUnsortedSubArray(arr, length);
	}

}
