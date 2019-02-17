package com.interview.Array;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

	public static void main(String[] args)  
	{ 
		int price[] = {10, 4, 5, 90, 120, 80}; 
		int n = price.length; 

		calculateSpan(price, n);  

		calculateSpanLinear(price, n);
	} 
	// Time Complexity --> O(n2)
	public static void calculateSpan(int price[], int n) 
	{ 
		int span[] = new int[n];
		// Span value of first day is always 1 
		span[0] = 1; 

		// Calculate span value of remaining days by linearly checking 
		// previous days 
		for (int i = 1; i < n; i++) 
		{ 
			span[i] = 1; // Initialize span value 

			// Traverse left while the next element on left is smaller 
			// than price[i] 
			for (int j = i-1; (j>=0)&&(price[i]>=price[j]); j--) 
				span[i]++; 
		} 

		System.out.println(Arrays.toString(span));
	} 
	//Time Complexity: O(n), Space Complexity: O(n)
	public static void calculateSpanLinear(int price[], int n) 
	{ 
		int span[] = new int[n];
		// Create a stack and push index of first element 
		// to it 
		Stack<Integer> st= new Stack<>(); 
		st.push(0);  

		// Span value of first element is always 1 
		span[0] = 1; 

		// Calculate span values for rest of the elements 
		for (int i = 1; i < n; i++) 
		{ 

			// Pop elements from stack while stack is not  
			// empty and top of stack is smaller than  
			// price[i] 
			while (!st.empty() && price[st.peek()] <= price[i]) 
				st.pop(); 

			// If stack becomes empty, then price[i] is  
			// greater than all elements on left of it, i.e.,  
			// price[0], price[1],..price[i-1]. Else price[i] 
			// is greater than elements after top of stack 
			span[i] = (st.empty())? (i + 1) : (i - st.peek()); 

			// Push this element to stack 
			st.push(i); 
		}
		System.out.println(Arrays.toString(span));
	} 
}
