package com.interview.Array;

/*
 * https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 * 
 * Given an array of n elements which contains elements from 0 to n-1, 
 * with any of these numbers appearing any number of times.
 */
public class FindDuplicatesFromArrayInLinearTimeConstantSpace {

	// Method 1 - This method print repeated number more than once.
	public static void printRepeatingUsingMakingElementNegativeApproach(int arr[], int size){ 
        
        System.out.println("The repeating elements are from method printRepeatingUsingMakingElementNegativeApproach: ");
     
        for (int i = 0; i < size; i++) {
            if (arr[Math.abs(arr[i])] >= 0) 
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])]; 
            else
                System.out.print(Math.abs(arr[i]) + " "); 
        }
        System.out.println("");
    }
	// Method 2 - This method print repeated number single time but the order is not maintained.
	public static void printRepeating(int arr[], int size){
		
	    for (int i = 0; i < size; i++){
	    	
	        int index = arr[i] % size; 
	        arr[index] += size; 
	    }
	    
	    System.out.println("The repeating elements are from method printRepeating: ");
	    for (int i = 0; i < size; i++){ 
	    	
	        if ((arr[i]/size) > 1)
	            System.out.print(i +" "); 
	    }
	    System.out.println("");
    }
    // Method 3 - This method will print repeated number single time in the order it is there in the original array
	
	public static void printDuplicates(int arr[], int n) {
	    
		int fl = 0;
		System.out.println("The repeating elements are from method printDuplicates: ");
	    for (int i= 0; i < n; i++){
	  
	        // Check if current element is 
	        // repeating or not. If it is 
	        // repeating then value will 
	        // be greater than or equal to n. 
	        if (arr[arr[i] % n] >= n){
	  
	            // Check if it is first 
	            // repetition or not. If it is 
	            // first repetition then value 
	            // at index arr[i] is less than 
	            // 2*n. Print arr[i] if it is 
	            // first repetition. 
	            if (arr[arr[i] % n] < 2 * n){
	                System.out.print( arr[i] % n + " "); 
	                fl = 1; 
	            }
	        }
	  
	        // Add n to index arr[i] to mark 
	        // presence of arr[i] or to 
	        // mark repetition of arr[i]. 
	        arr[arr[i] % n] += n; 
	    }
	    System.out.println(" ");
	  
	    if (!(fl > 0)) {
	        System.out.println("No Duplicate element present in the array.");
	    }
	}
	public static void main(String args[]) {
		int arr[] = { 1, 6, 3, 1, 3, 6, 6 };
		int arr_size = arr.length;

		printRepeating(arr, arr_size);
		
		arr = new int[]{ 1, 6, 3, 1, 3, 6, 6 };
		printRepeatingUsingMakingElementNegativeApproach(arr, arr_size);
		
		arr = new int[]{ 1, 6, 3, 1, 3, 6, 6 };
		printDuplicates(arr, arr_size);
	}
}
