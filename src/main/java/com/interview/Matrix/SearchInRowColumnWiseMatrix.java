package com.interview.Matrix;

public class SearchInRowColumnWiseMatrix {

	/*
	 * https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
	 * Every row and every column is individually sorted.
	 * 
	 * Time Complexity: O(n)

	 * The above approach will also work for m x n matrix (not only for n x n). 
	 * Complexity would be O(m + n).
	 */
	
	private static void search(int[][] array, int length, int searchElement) {
		
		int i = 0;
		int j = length - 1;
		
		while (i < length && j >= 0) {
			if (array[i][j] == searchElement) {
				System.out.print(searchElement+ " Element Found at (" + i + " , " + j+")");
				return;
			}
			if (array[i][j] > searchElement)
				j--;
			else // if mat[i][j] < x
				i++;
		}

		System.out.print(searchElement + " Element not found");
		return;
	}
	
	public static void main(String[] args) {
		int array[][] = {{0, 6, 8, 9, 11}, 
                {20, 22, 28, 29, 31}, 
                {36, 38, 50, 61, 63}, 
                {64, 66, 100, 122, 128}};

		search(array, 5, 128);
	}

	
}
