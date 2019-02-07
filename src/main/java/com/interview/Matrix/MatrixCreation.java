package com.interview.Matrix;

public class MatrixCreation {

	public static void main(String[] args) {

		int rows = 2;
		int columns = 3;

		createStaticMatrix(rows, columns);

	}

	public static int[][] createStaticMatrix(int rows, int columns) {

		int[][] arr = new int[rows][columns];

		int value = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				arr[i][j] = ++value;
			}
		}
		MatrixPrint.print(arr, rows, columns);
		return arr;

	}
	public static int[][] createDynamicMatrix(int rows, int columns) {

		int[][] arr = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				arr[i][j] = getRandomNumber(15); // This range can also be Dynamic
			}
		}
		MatrixPrint.print(arr, rows, columns);
		return arr;

	}
	private static int getRandomNumber(int range){
		return (int )(Math.random() * range + 1);
	}
}
