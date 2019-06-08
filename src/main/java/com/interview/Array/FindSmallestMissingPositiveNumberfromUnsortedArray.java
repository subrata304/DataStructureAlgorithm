package com.interview.Array;

/*
 * You are given an unsorted array with both positive and negative elements. 
 * You have to find the smallest positive number missing from the array
 */
public class FindSmallestMissingPositiveNumberfromUnsortedArray {

	public static int segregate(int arr[], int size) {
		int countOfNegative = 0;
		for (int i = 0; i < size; i++) {
			if (arr[i] <= 0) {
				int temp;
				temp = arr[i];
				arr[i] = arr[countOfNegative];
				arr[countOfNegative] = temp;
				countOfNegative++;
			}
		}

		return countOfNegative;
	}

	public static int findMissingPositive(int arr[], int size) {
		
		int startOfPositive = segregate(arr, size);
        
		for (int i = startOfPositive; i < arr.length; i++) {
            int index = Math.abs(arr[i]) + startOfPositive - 1;
            if (index < arr.length) {
                arr[index] = -Math.abs(arr[index]);
            }
        }
        for (int i = startOfPositive; i < arr.length; i++) {
            if (arr[i] > 0) {
                return i - startOfPositive + 1;
            }
        }
        return arr.length - startOfPositive + 1;
	}

	public static void main(String[] args) {

		int arr[] = { 2, 3, -7, 6, 8, 1, -10, 15 };
		int arr_size = arr.length;
		int missing = findMissingPositive(arr, arr_size);

		System.out.println("The smallest positive missing number is " + missing);
	}
}
