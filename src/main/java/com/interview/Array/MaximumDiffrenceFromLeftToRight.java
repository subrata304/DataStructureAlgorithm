package com.interview.Array;

/*
 * https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 */
public class MaximumDiffrenceFromLeftToRight {

	public static int maxDiff(int arr[], int arr_size) {
		int max_diff = arr[1] - arr[0];
		int min_element = arr[0];
		int i;
		for (i = 1; i < arr_size; i++) {
			if (arr[i] - min_element > max_diff)
				max_diff = arr[i] - min_element;
			if (arr[i] < min_element)
				min_element = arr[i];
		}
		return max_diff;
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 90, 10, 110 };
		int size = arr.length;
		System.out.println("MaximumDifference is " + maxDiff(arr, size));
	}
}
