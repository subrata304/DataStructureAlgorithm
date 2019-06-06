package com.interview.Array;

public class CountOfDuplicateElementFromAnArray {


	//Approach 1 : Loop through the whole array and get the count - O(N)
	//Approach 2: Get the element using Binary Search - O(logn) and then 
	//go to left and right to find other occurences. which is O(N),
	//In worst case it will go till O(logn) + O(N) = O(N) when all elements are same.
	
	//Approach 3: we will find the first and last occurences of the given number and find the total count
	//This will take O(logN)
	
	
	private static int findCount(int[] arr, int element, int n) {
		
		int firstOccurenceIndex, lastOccurenceIndex;
		
		firstOccurenceIndex = binarySearch(arr, element, 0, n-1, true);
		lastOccurenceIndex = binarySearch(arr, element, 0, n-1, false);
		
		return  lastOccurenceIndex - firstOccurenceIndex + 1; 
	}
	private static int binarySearch(int[] arr, int element, int low, int high, boolean searchFirst) {
		int result = 0;
		while(low <= high) {
			int mid = (low+high)/2;
			if(arr[mid] == element) {
				result = mid;
				if(searchFirst) {
					high = mid -1;
				}else {
					low = mid +1;
				}
			}
			else if(arr[mid] > element) {
				high = mid - 1;
			}else {
				low = mid +1;
			}
			
		}
		return result;
	}
	public static void main(String[] args) {
		int arr[] = {1, 1, 3, 3, 5, 5, 5, 5, 5, 9, 9, 11}; 
        
        int element =  5;  
        int n = arr.length; 
        int count = findCount(arr, element, n); 
        
        System.out.println(element+" occurs "+ count +" times"); 
	}

	
}
