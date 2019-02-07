package com.interview.Array;

import java.util.Arrays;

public class RearrangeArraywithNoSpace {

	/*
	 * Given an array arr[] of size n where every element is in range from 0 to n-1. 
	 * Rearrange the given array so that arr[i] becomes arr[arr[i]]. 
	 * This should be done with O(1) extra space.
	 */
	
	public static void main(String[] args) {
		
		/*
		 * 1) Increase every array element arr[i] by (arr[arr[i]] % n)*n.
		   2) Divide every element by n.
		   
		   Let us understand the above steps by an example array {3, 2, 0, 1}
		   
		   In first step, every value is incremented by (arr[arr[i]] % n)*n
		   After first step array becomes {7, 2, 12, 9}. 
		   The important thing is, after the increment operation
		   of first step, every element holds both old values and new values. 
		   
		   Old value can be obtained by arr[i]%n and 
		   new value can be obtained by arr[i]/n.
		   
		   In second step, all elements are updated to new or output values 
		   by doing arr[i] = arr[i]/n.
		 */
		int arr[] = {3, 2, 0, 1}; 
		int n = arr.length; 
		// First step: Increase all values by (arr[arr[i]]%n)*n 
        for (int i = 0; i < n; i++) 
            arr[i] += (arr[arr[i]] % n) * n; 
  
        // Second Step: Divide all values by n 
        for (int i = 0; i < n; i++) 
            arr[i] /= n; 
        
        System.out.println("Output Array is : "+ Arrays.toString(arr));
	}
}
