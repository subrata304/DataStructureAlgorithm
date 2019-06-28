package com.interview.Array;
/*
 * https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 * 
 * Input: arr[] = {4, 3, 6, 2, 1, 1}
 * Output: Missing = 5, Repeating = 1
 * 
 * Array elements are in the range from 1 to n.
 * 
 */

public class FindRepeatingAndMissingNumber {

	public static void getTwoElementsUsingXOR(int arr[], int n) {
		
		int xor1; int x; int y;

		/* Will have only single set bit of xor1 */
		int set_bit_no;

		int i;
		x = 0;
		y = 0;

		xor1 = arr[0];

		/* Get the xor of all array elements */
		for (i = 1; i < n; i++)
			xor1 = xor1 ^ arr[i];

		/*
		 * XOR the previous result with numbers from 1 to n
		 */
		for (i = 1; i <= n; i++)
			xor1 = xor1 ^ i;

		/* Get the rightmost set bit in set_bit_no */
		set_bit_no = xor1 & ~(xor1 - 1);
		Integer.lowestOneBit(xor1);
		
		Integer.highestOneBit(xor1);
		/*
		 * Now divide elements into two sets by comparing rightmost set bit of xor1 with
		 * the bit at the same position in each element. Also, get XORs of two sets. The
		 * two XORs are the output elements. The following two for loops serve the
		 * purpose
		 */
		for (i = 0; i < n; i++) {
			if ((arr[i] & set_bit_no) != 0)
				/* arr[i] belongs to first set */
				x = x ^ arr[i];

			else
				/* arr[i] belongs to second set */
				y = y ^ arr[i];
		}
		for (i = 1; i <= n; i++) {
			if ((i & set_bit_no) != 0)
				/* i belongs to first set */
				x = x ^ i;

			else
				/* i belongs to second set */
				y = y ^ i;
		}
		
		System.out.println("Missing and repeating Elements are: " + x + " " + y);

	}
	
	public static void printTwoElementsMakingNegative(int arr[], int size) {
		int i;
		System.out.print("The repeating element is ");

		for (i = 0; i < size; i++) {
			int abs_val = Math.abs(arr[i]);
			if (arr[abs_val - 1] > 0)
				arr[abs_val - 1] = -arr[abs_val - 1];
			else
				System.out.println(abs_val);
		}

		System.out.print("And the missing element is ");
		for (i = 0; i < size; i++) {
			if (arr[i] > 0)
				System.out.println(i + 1);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 4, 5, 1, 7, 2 };
		getTwoElementsUsingXOR(arr, arr.length);
		
		printTwoElementsMakingNegative(arr, arr.length);
	}
}
