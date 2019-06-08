package com.interview.Array;

/*
 * Given an array of size n, the array contains numbers in range from 0 to k-1 where k is a positive integer and k <= n. 
 * Find the maximum repeating number in this array. For example, 
 * let k be 10 the given array be arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3}, 
 * the maximum repeating number would be 2. 
 */

public class FindMaximumRepeatingNumberFromUnsortedArray {

	public static int maxRepeating(int arr[], int n, int k) {
		// Iterate though input array, for every element
		// arr[i], increment arr[arr[i]%k] by k
		for (int i = 0; i < n; i++)
			arr[(arr[i] % k)] += k;

		// Find index of the maximum repeating element
		int max = arr[0], result = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
				result = i;
			}
		}

		/*
		 * Uncomment this code to get the original array back for (int i = 0; i< n; i++)
		 * arr[i] = arr[i]%k;
		 */

		// Return index of the maximum element
		return result;
	}

	public static void main(String[] args) {

		int arr[] = { 2, 3, 3, 5, 3, 4, 1, 7 };
		int n = arr.length;
		int k = 8;
		System.out.println("Maximum repeating element is: " + maxRepeating(arr, n, k));
	}
	
	/*
	 * Since we use arr[i]%k as index and add value k at the index arr[i]%k, 
	 * the index which is equal to maximum repeating element will have the maximum value in the end. 
	 * Note that k is added maximum number of times at the index equal to maximum repeating element and 
	 * all array elements are smaller than k.
	 */
}
