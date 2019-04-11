package com.interview.Array;

public class FindDuplicatesFromArrayInLinearTimeConstantSpace {

	static void printRepeating(int arr[], int size) 
    { 
		// First check all the values that are 
	    // present in an array then go to that 
	    // values as indexes and increment by 
	    // the size of array 
	    for (int i = 0; i < size; i++) 
	    { 
	        int index = arr[i] % size; 
	        arr[index] += size; 
	    } 
	  
	    // Now check which value exists more 
	    // than once by dividing with the size 
	    // of array 
	    for (int i = 0; i < size; i++) 
	    { 
	        if ((arr[i]/size) > 1) 
	            System.out.println(i +" "); 
	    }  
    }  
    
	public static void main(String args[]) {
		int arr[] = { 1, 6, 3, 1, 3, 6, 6 };
		int arr_size = arr.length;

		System.out.println("The repeating elements are: ");
		printRepeating(arr, arr_size);
	}
}
