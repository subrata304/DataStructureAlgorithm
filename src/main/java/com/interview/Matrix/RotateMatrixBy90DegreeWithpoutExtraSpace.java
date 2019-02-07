package com.interview.Matrix;

public class RotateMatrixBy90DegreeWithpoutExtraSpace {

	/*
	 * Condition is Given Matrix is Square Matrix.
	 * Input:
	   -------
		 1  2  3
		 4  5  6
		 7  8  9
	   Output:
	   -------
		 3  6  9 
		 2  5  8 
		 1  4  7 
	 */
	public static void main(String[] args) {
		
		int rows = 4;
		int columns = 4;
		int[][] m1 = MatrixCreation.createStaticMatrix(rows, columns);
		
		rotateMatrixAntiClockWise(m1, rows, columns);
	}

	public static void rotateMatrixAntiClockWise(int[][] m1, int rows, int columns) {
		/*
		 * Below are some important observations.
		   First row of source –> First column of destination, elements filled in opposite order
		   Second row of source –> Second column of destination, elements filled in opposite order
		   
		   There are two steps:
			1. Find transpose of matrix.
			2. Reverse columns of the transpose.
		   
		 */
		int[][] transpose = transposeMatric(m1, rows, columns);
		reverseColumns(transpose, rows, columns);
		
	}
	
	public static int[][] transposeMatric(int[][] m1, int rows, int columns) {
		for (int i = 0; i < columns; i++) {
			for (int j = i; j < rows; j++) {
				int temp = m1[j][i]; 
				m1[j][i] = m1[i][j]; 
				m1[i][j] = temp; 
			}
		}
		System.out.println("Transpose Matrix: ");
		MatrixPrint.print(m1, rows, columns);
		return m1;
	}
	public static void reverseColumns(int arr[][], int rows, int columns) 
    { 
        for (int i = 0; i < columns; i++) 
            for (int j = 0, k = columns - 1; 
                 j < k; j++, k--) {
                int temp = arr[j][i]; 
                arr[j][i] = arr[k][i]; 
                arr[k][i] = temp; 
            }
        
    	System.out.println("Left/AntiClockWise 90 degree Rotated Matrix: ");
		MatrixPrint.print(arr, arr.length, arr[0].length);
    }
}
