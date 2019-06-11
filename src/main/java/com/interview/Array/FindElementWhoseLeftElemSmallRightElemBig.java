package com.interview.Array;

/*
 * https://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/
 * 
 * Approach 1: 
 * Take two arrays, one is LeftMax which will have max element from left at each position w.r.t leftside elements
 * Another is rightMin which will have min element from right at each position w.r.t. rightside elements.
 * Go through the original array and the element which is greater than equal to corresponding to leftMax element and
 * less than equal to corresponding to rightMin element print the same.
 * 
 * Approach 2: We don't need the second array i.e. rightMin.
 */
public class FindElementWhoseLeftElemSmallRightElemBig {

	public static int findElement(int arr[], int n) 
	{ 
		// leftMax[i] stores maximum of arr[0..i-1] 
		int[] leftMax = new int[n]; 
		//leftMax[0] = Integer.MIN_VALUE; 

		leftMax[0] = arr[0];
		// Fill leftMax[]1..n-1] 
		for (int i = 1; i < n; i++) 
			leftMax[i] = Math.max(leftMax[i-1], arr[i]); 

		//Approach 1: Second array 
		
//		int[] rightMinArr = new int[n];
//		
//		rightMinArr[n-1] = arr[n-1];
//		for (int i = n-2; i >= 0; i--) 
//			rightMinArr[i] = Math.min(rightMinArr[i+1], arr[i]); 
//
//		for(int i=0; i < n ; i++) {
//			if(arr[i] >= leftMax[i] &&
//					arr[i] <= rightMinArr[i]) {
//				System.out.println("Index Is: "+ i);
//			}
//		}
		
		// Initialize minimum from right 
		int rightMin = Integer.MAX_VALUE; 

		// Traverse array from right 
		for (int i=n-1; i>=0; i--) 
		{ 
			// Check if we found a required element 
			if (leftMax[i] <= arr[i] && rightMin > arr[i]) 
				return i; 

			// Update right minimum 
			rightMin = Math.min(rightMin, arr[i]); 
		} 
		

		// If there was no element matching criteria 
		return -1; 
	}

	public static void main(String[] args) {
		int arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
		//int arr[] = {3, 2, 4, 6, 9, 8, 7}; // Two Elements present
		int index = findElement(arr, arr.length);
		System.out.println("Index: " + index + " Element: " + (index!= -1 ? arr[index] : -1));
	}
}
