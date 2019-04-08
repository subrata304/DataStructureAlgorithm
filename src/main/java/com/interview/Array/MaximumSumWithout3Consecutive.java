package com.interview.Array;

/*
 * https://www.geeksforgeeks.org/maximum-subsequence-sum-such-that-no-three-are-consecutive/
 * 
 * Given a sequence of positive numbers, find the maximum sum that can be formed which 
 * has no three consecutive elements present.
 * 
 * Input: arr[] = {1, 2, 3}
 *	Output: 5
 *	We can't take three of them, so answer is
	2 + 3 = 5
	
	Input: arr[] = {3000, 2000, 1000, 3, 10}
	Output: 5013 
	3000 + 2000 + 3 + 10 = 5013
	
	Input: arr[] = {100, 1000, 100, 1000, 1}
	Output: 2101
	100 + 1000 + 1000 + 1 = 2101
	
	Input: arr[] = {1, 1, 1, 1, 1}
	Output: 4
 */

public class MaximumSumWithout3Consecutive {

	private static int maxSumWithout3Consecutive(int[] arr, int length) {
		
        int sum[] = new int[length];
        
        if (length >= 1) 
            sum[0] = arr[0]; 
  
        if (length >= 2) 
            sum[1] = arr[0] + arr[1];
        
        if (length > 2) 
            sum[2] = Math.max(sum[1], Math.max(arr[1] + arr[2], arr[0] + arr[2])); 
        
        // Process rest of the elements 
        // We have three cases 
        // 1) Exclude arr[i], i.e., sum[i] = sum[i-1] 
        // 2) Exclude arr[i-1], i.e., sum[i] = sum[i-2] + arr[i] 
        // 3) Exclude arr[i-2], i.e., sum[i-3] + arr[i] + arr[i-1] 
        for (int i = 3; i < length; i++) {
            sum[i] = Math.max(Math.max(sum[i - 1], sum[i - 2] + arr[i]), 
                              arr[i] + arr[i - 1] + sum[i - 3]); 
        }
        return sum[length - 1];
	}
	public static void main(String[] args) {
		int arr[] = { 3000, 2000, 1000, 3, 10};
		System.out.println(maxSumWithout3Consecutive(arr, arr.length));
	}
}
