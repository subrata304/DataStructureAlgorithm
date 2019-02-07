package com.interview.Matrix;

public class TransposeMatrix {

	public static void main(String[] args) {

		int rows = 3;
		int columns = 3;
		int[][] m1 = MatrixCreation.createStaticMatrix(rows, columns);

		transposeMatric(m1, rows, columns);
	}

	public static int[][] transposeMatric(int[][] m1, int rows, int columns) {
		int[][] tranpose = new int[columns][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				tranpose[j][i] = m1[i][j];
			}
		}
		MatrixPrint.print(tranpose, columns, rows);
		return tranpose;
	}
}
