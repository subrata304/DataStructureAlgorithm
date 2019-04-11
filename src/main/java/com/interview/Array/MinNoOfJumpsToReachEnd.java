package com.interview.Array;

/*
 * https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/
 * https://www.youtube.com/watch?v=cETfFsSTGJI
 * 
 *  Given an array of non negative integers where each element represents the max 
 *  number of steps that can be made forward from that element. Write a function to 
 *  return the minimum number of jumps to reach the end of the array from first element
 */
public class MinNoOfJumpsToReachEnd {

	
	//Approach 1: Dynamic Programming
	// Time Complexity - O(N2) and Space Complexity - O(N)
	
	private static int minJumps(int[] arr, int n) {
		int jumps[] = new int[n];
		int i, j;

		if (n == 0 || arr[0] == 0)
			return Integer.MAX_VALUE; // if first element is 0,

		jumps[0] = 0;

		// Find the minimum number of jumps to reach arr[i]
		// from arr[0], and assign this value to jumps[i]
		for (i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (j = 0; j < i; j++) {
				if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					break;
				}
			}
		}
		return jumps[n - 1];
	}
	
	//Approach 2: ladder and Stairs approach Time and Space Complexity = O(N)
	public static int jump(int[] nums) {

		if (nums.length == 1)
			return 0;

		int steps = 0;
		int limit = 0;
		int next = 0;

		for (int i = 0; i < nums.length; i++) {

			next = Math.max(next, i + nums[i]);

			if (i == limit) {
				steps++;
				limit = next;
				if (limit >= nums.length - 1)
					return steps;
			}
		}

		return steps;
	}
	public static void main(String[] args) { 
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}; 

		System.out.println("Minimum number of jumps to reach end is : "+ 
				minJumps(arr,arr.length)); 
		
		System.out.println("Minimum number of jumps to reach end is : "+ 
				jump(arr)); 
	}
}
