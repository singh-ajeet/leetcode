package org.ajeet.learnings.leetcode.easy.arrays;

public final class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
       // int[] input = {7,1,5,3,6,4};
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(input));
    }
}
