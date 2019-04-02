package com.interview.Array;

/*
 * Find the element which exists more than 50% in the given array
 */
public class MajorityIndex {

	public void printMajority(int a[], int size) {
		

		/* Time Complexity is O(N)*/
		
		int cand = findCandidate(a, size);
			
		if (isMajority(a, size, cand))
			System.out.println(" " + cand + " ");
		else
			System.out.println("No Majority Element");
	}

	public int findCandidate(int a[], int size) {
		int maj_index = 0, count = 1;
		int i;
		for (i = 1; i < size; i++) {
			if (a[maj_index] == a[i])
				count++;
			else
				count--;
			if (count == 0) {
				maj_index = i;
				count = 1;
			}
		}
		return a[maj_index];
	}

	boolean isMajority(int a[], int size, int cand) {
		int i, count = 0;
		for (i = 0; i < size; i++) {
			if (a[i] == cand)
				count++;
		}
		if (count > size / 2)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		MajorityIndex majorelement = new MajorityIndex();
		int a[] = new int[] { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		int size = a.length;
		majorelement.printMajority(a, size);
	}
}
