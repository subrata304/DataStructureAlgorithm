package com.interview.Matrix;

public class MatrixMutiplication {

	public static void main(String[] args) {
		
		int noOfRowsFirstMatrix = 2;
		int noOfColumnsFirstMatrix = 3;
		int noOfRowsSecondMatrix = 3;
		int noOfColumnsSecondMatrix = 2;
		
		if(noOfColumnsFirstMatrix!= noOfRowsSecondMatrix ) {
			System.out.println("Matrix Multiplication is not possible "
					+ "as columns in first matrix doesn't match with rows of second matrix.");
			return;
		}
		
		int[][] m1 = MatrixCreation.createStaticMatrix(noOfRowsFirstMatrix, noOfColumnsFirstMatrix);
		int[][] m2 = MatrixCreation.createStaticMatrix(noOfRowsSecondMatrix, noOfColumnsSecondMatrix);
		
		int[][] result = new int[noOfRowsFirstMatrix][noOfColumnsSecondMatrix];
		int sum =0;
		
		for(int i = 0; i< noOfRowsFirstMatrix; i++ ) {
			for(int j = 0; j< noOfColumnsSecondMatrix; j++) {
				for(int k = 0; k < noOfRowsSecondMatrix; k++) {
					sum = sum + m1[i][k] * m2[k][j];
				}
				result[i][j] = sum;
				sum =0;
			}
		}
		MatrixPrint.print(result, noOfRowsFirstMatrix, noOfColumnsSecondMatrix);
	}
}
