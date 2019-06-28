package com.interview.DynamicProgramming;

/*
 * 
 * 0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight
 * how to pick items to pick items from this set to maximize sum of value of items such that
 * sum of weights is less than or equal to maximum allowed weight.
 *
 * Time Complexity: O(nW) where n is the number of items and W is the capacity of knapsack.
 *
 */
public class KnapsackProblem_0_1 {

	/*
	 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/Knapsack01.java
	 * https://www.youtube.com/watch?v=8LusJS5-AGo&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
	 * 
	 * Need to understad the top down approach from the above code and video and the commit. PENDING
	 */
	
	/**
     * Solves 0/1 knapsack in bottom up dynamic programming
     */
    public int bottomUpDP(int val[], int wt[], int W){
        int K[][] = new int[val.length+1][W+1];
        for(int i=0; i <= val.length; i++){
            for(int j=0; j <= W; j++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                if(j - wt[i-1] >= 0){
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
                }else{
                    K[i][j] = K[i-1][j];
                }
            }
        }
        
        int res = K[val.length][W];
        System.out.println("Total Value :: " + res); 
  
		int w = W;
		for (int i = val.length; i > 0 && res > 0; i--) {

			// either the result comes from the top
			// (K[i-1][w]) or from (val[i-1] + K[i-1]
			// [w-wt[i-1]]) as in Knapsack table. If
			// it comes from the latter one/ it means
			// the item is included.
			if (res == K[i - 1][w])
				continue;
			else {

				// This item is included.
				System.out.print(wt[i - 1] + " ");

				// Since this weight is included its
				// value is deducted
				res = res - val[i - 1];
				w = w - wt[i - 1];
			}
		}
        return K[val.length][W];
    }
    
    
	public static void main(String args[]) {
		KnapsackProblem_0_1 k = new KnapsackProblem_0_1();
		int val[] = {1,4,5,7 };
		int wt[] = { 1,3,4,5 };
		int r = k.bottomUpDP(val, wt, 7);
		//int r1 = k.topDownRecursive(val, wt, 30);
		
		//System.out.println(r1);
	}

}
