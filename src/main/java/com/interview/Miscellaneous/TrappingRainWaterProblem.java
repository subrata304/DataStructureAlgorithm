package com.interview.Miscellaneous;

public class TrappingRainWaterProblem {

	public static void main(String[] args) {
		int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		findWaterUsingSpace(arr);
		findWaterWithoutSpace(arr);
	}

	/*
	 * Time and Space Complexity is: O(N)
	 */
	public static void findWaterUsingSpace(int[] arr) {

		int length = arr.length;
		// left[i] contains height of tallest bar to the
		// left of i'th bar including itself
		int left[] = new int[length];

		// Right [i] contains height of tallest bar to
		// the right of ith bar including itself
		int right[] = new int[length];

		// Initialize result
		int water = 0;

		// Fill left array
		left[0] = arr[0];
		for (int i = 1; i < length; i++)
			left[i] = Math.max(left[i - 1], arr[i]);

		// Fill right array
		right[length - 1] = arr[length - 1];
		for (int i = length - 2; i >= 0; i--)
			right[i] = Math.max(right[i + 1], arr[i]);

		// Calculate the accumulated water element by element
		// consider the amount of water on i'th bar, the
		// amount of water accumulated on this particular
		// bar will be equal to min(left[i], right[i]) - arr[i] .
		for (int i = 0; i < length; i++)
			water = water + Math.min(left[i], right[i]) - arr[i];

		System.out.println("Method: findWaterUsingSpace:: Maximum water can be accumulated is : " + water);
	}
	/*
	 * Time Complexity is: O(N)
	 * Space Complexity is: O(1)
	 */
	public static void findWaterWithoutSpace(int arr[]) {

		int lenght = arr.length;
		int water = 0;
		int left_max = 0, right_max = 0;

		// indices to traverse the array
		int lo = 0, hi = lenght - 1;

		while (lo <= hi) {
			if (arr[lo] < arr[hi]) {
				if (arr[lo] > left_max)

					// update max in left
					left_max = arr[lo];
				else

					// water on curr element =
					// max - curr
					water += left_max - arr[lo];
				lo++;
			} else {
				if (arr[hi] > right_max)

					// update right maximum
					right_max = arr[hi];

				else
					water += right_max - arr[hi];
				hi--;
			}
		}

		System.out.println("Method: findWaterWithoutSpace:: Maximum water can be accumulated is : " + water);
	}
}
