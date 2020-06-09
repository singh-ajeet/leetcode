package org.ajeet.learnings.leetcode.medium.dp;

import java.util.Arrays;

public final class CoinChange {

    public int coinChange(int[] coins, int sum){
        //Because array is 0 based so array's size should be 'sum + 1'
        int[] dp = new int[sum + 1];
        // Just to differentiate between processed and unprocessesd cells
        Arrays.fill(dp, sum + 1);
        dp[0] = 0; // To make sum 0, we need 0 coins

        for(int s=1; s<=sum; s++) {
            for (int i=0; i<coins.length; i++){
                if(coins[i] <= s) {
                    dp[s] =  Math.min(dp[s], 1 + dp[s-coins[i]]);
                }
            }
        }

        return dp[sum] > sum ? -1 : dp[sum];
    }

}
