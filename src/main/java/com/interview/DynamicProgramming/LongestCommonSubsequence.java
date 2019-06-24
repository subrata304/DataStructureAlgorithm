package com.interview.DynamicProgramming;

public class LongestCommonSubsequence {

	/*
	 * Time Complexity of the above implementation is O(mn) where m and n are the length of the strings
	 */
	
	public void lcsDP(String string1,String string2){
		
		char str1[] = string1.toCharArray();
		char str2[] = string2.toCharArray();
	    
        int temp[][] = new int[str1.length + 1][str2.length + 1];
        int max = 0;
        for(int i=1; i < temp.length; i++){
            for(int j=1; j < temp[i].length; j++){
                if(str1[i-1] == str2[j-1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                }
                else
                {
                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
                }
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }
       // return max;
        
        // Print the longest Common Subsequence
        
        // Following code is used to print LCS 
        int index = temp[string1.length()][string2.length()]; 
        int pointer = index; 

        // Create a character array to store the lcs string 
        char[] lcs = new char[index+1]; 
        //lcs[index] = ''; // Set the terminating character 

        // Start from the right-most-bottom-most corner and 
        // one by one store characters in lcs[] 
        int i = str1.length, j = str2.length; 
        while (i > 0 && j > 0) 
        { 
        	// If current character in X[] and Y are same, then 
        	// current character is part of LCS 
        	if (string1.charAt(i-1) == string2.charAt(j-1)) 
        	{ 
        		// Put current character in result 
        		lcs[index-1] = string2.charAt(i-1);  

        		// reduce values of i, j and index 
        		i--;  
        		j--;  
        		index--;      
        	} 

        	// If not same, then find the larger of two and 
        	// go in the direction of larger value 
        	else if (temp[i-1][j] > temp[i][j-1]) 
        		i--; 
        	else
        		j--; 
        } 

        // Print the lcs 
        System.out.print("LCS of "+string1+" and "+string2+" is "); 
        for(int k=0;k<=pointer;k++) 
        	System.out.print(lcs[k]); 
    
    }
	
	public static void main(String args[]) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String str1 = "ABCDGHLQR";
		String str2 = "AEDPHR";

		lcs.lcsDP(str1, str2);
		
	}
}
