package com.interview.DynamicProgramming;

public class MaxSumWithNoTwoAdjacentElement {

	/*
	 * Time Complexity - O(N)
	 * https://www.techiedelight.com/maximum-sum-of-subsequence-with-no-adjacent-elements/
	 * 
	 * DP Problem
	 */
	public int maximumSum(int arr[]) {
        int excl = 0;
        int incl = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = incl;
            incl = Math.max(excl + arr[i], incl);
            excl = temp;
        }
        return incl;
    }

	public static void main(String args[]) {
		MaxSumWithNoTwoAdjacentElement sumWithNoTwoAdjacentElement = new MaxSumWithNoTwoAdjacentElement();
        int arr[] = { 3, 2, 5, 10, 7 };
        System.out.println(sumWithNoTwoAdjacentElement.maximumSum(arr));

    }
}
