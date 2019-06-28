package com.interview.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * 
 * Given a value N, if we want to make change for N cents, and 
 * we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
 * how many ways can we make the change? The order of coins doesn’t matter.
 * 
 * For example, for N = 4 and S = {1,2,3}, 
 * there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 * 
 * https://www.youtube.com/watch?v=jaNZ83Q3QGc
 */

public class CoinChangeProblem {

	public static int count( int S[], int size, int total ){
		
	    // table[i] will be storing the number of solutions for 
	    // value i. We need n+1 rows as the table is constructed 
	    // in bottom up manner using the base case (n = 0) 
	    int table[]=new int[total+1]; 
	  
	    // Base case (If given value is 0) 
	    table[0] = 1; 
	  
	    // Pick all coins one by one and update the table[] values 
	    // after the index greater than or equal to the value of the
	    // picked coin
	    for(int i=0; i<size; i++) {
	    	for(int j=1; j <= total ; j++){
	    		if(j >= S[i]){
	    	    	table[j] = table[j]  + table[j-S[i]];
	    		}
	    	}
	    }
	    return table[total]; 
	}
	
	 /**
     * This method actually prints all the combination. It takes exponential time.
     */
    public static void printCoinChangingSolution(int total,int coins[]){
        List<Integer> result = new ArrayList<>();
        printActualSolution(result, total, coins, 0);
    }
    
    private static void printActualSolution(List<Integer> result,int total,int coins[],int pos){
        if(total == 0){
            for(int r : result){
                System.out.print(r + " ");
            }
            System.out.print("\n");
        }
        for(int i=pos; i < coins.length; i++){
            if(total >= coins[i]){
                result.add(coins[i]);
                printActualSolution(result,total-coins[i],coins,i);
                result.remove(result.size()-1);
            }
        }
    }

	public static void main(String args[]) {
		int arr[] = { 1, 2, 5, 10 };
		int length = arr.length;
		int total = 10;
		System.out.println("Total No of Ways: " +count(arr, length, total));
		
		printCoinChangingSolution(total, arr);
		
	}
}
