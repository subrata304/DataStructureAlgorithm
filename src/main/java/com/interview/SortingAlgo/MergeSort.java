package com.interview.SortingAlgo;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] array = new int[10];
		populateArray(array);

		System.out.println("Before sorting \n"+Arrays.toString(array));

		array = merge_sort(array);

		System.out.println("after sorting \n"+Arrays.toString(array));
	}

	public static int[] merge_sort(int[] arrayToSort) {
		if (arrayToSort.length <= 1) {
			return arrayToSort;
		}
		int midpoint = arrayToSort.length / 2;
		int[] left = new int[midpoint];
		int[] right;
		if (arrayToSort.length % 2 == 0) {
			right = new int[midpoint];

		} else {
			right = new int[midpoint + 1];

		}
		int[] result = new int[arrayToSort.length];
		for (int i = 0; i < midpoint; i++) {
			left[i] = arrayToSort[i];
		}
		int x = 0;
		for (int j = midpoint; j < arrayToSort.length; j++) {
			if (x < right.length) {
				right[x] = arrayToSort[j];
				x++;
			}
		}
		left = merge_sort(left);
		right = merge_sort(right);

		result = merge(left, right);

		return result;
	}

	public static int[] merge(int[] left, int[] right) {
		int lengthresult = left.length + right.length;
		int[] result = new int[lengthresult];
		int leftIndex = 0;
		int rightIndex = 0;
		int indexRes = 0;
		while (leftIndex < left.length || rightIndex < right.length) {
			if (leftIndex < left.length && rightIndex < right.length) {
				if (left[leftIndex] <= right[rightIndex]) {
					result[indexRes] = left[leftIndex];
					leftIndex++;
					indexRes++;
				} else {
					result[indexRes] = right[rightIndex];
					rightIndex++;
					indexRes++;
				}
			} else if (leftIndex < left.length) {
				result[indexRes] = left[leftIndex];
				leftIndex++;
				indexRes++;

			} else if (rightIndex < right.length) {
				result[indexRes] = right[rightIndex];
				rightIndex++;
				indexRes++;
			}
		}
		return result;
	}

	public static int[] populateArray(int[] s) {
		for (int i = 0; i < s.length; i++) {
			int randomFileSize = Double.valueOf((Math.random() + 1) * 10).intValue();
			s[i] = randomFileSize;
		}
		return s;
	}
}