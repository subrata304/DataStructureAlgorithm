package com.interview.Matrix;

public class MatrixPrint {

	public static void print(int[][] arr, int rows, int columns) {
		System.out.println("Matrix with rows: "+ rows + " and Columns: " + columns + "  is as below: ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("====================");
	}
}
