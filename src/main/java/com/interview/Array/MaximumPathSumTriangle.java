package com.interview.Array;

public class MaximumPathSumTriangle {

	static int N = 3;

	// Function for finding maximum sum
	public static int maxPathSum(int tri[][], int m, int n) {
		// loop for bottom-up calculation
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				// for each element, check both
				// elements just below the number
				// and below right to the number
				// add the maximum of them to it
				if (tri[i + 1][j] > tri[i + 1][j + 1])
					tri[i][j] += tri[i + 1][j];
				else
					tri[i][j] += tri[i + 1][j + 1];
			}
		}

		// return the top element
		// which stores the maximum sum
		return tri[0][0];
	}

	public static void main(String[] args) {
		int tri[][] = { 
				{ 3, 0, 0, 0 }, 
				{ 7, 4, 0, 0 }, 
				{ 2, 4, 6, 0 },
				{ 8, 5, 9, 3 }
			};
		System.out.println(maxPathSum(tri, 3, 3));
	}
}
