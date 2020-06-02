package org.ajeet.learnings.leetcode.easy.dp;

public final class BestTimetoBuyandSellStock {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int price : prices){
            if(minPrice > price)
                minPrice  = price;
            else {
                int p = price - minPrice;
                if(p > profit)
                    profit = p;
            }
        }
        return profit;
    }

    public static int maxProfit1(int[] prices) {
        int n = prices.length-1;

        int profit = 0;
        //buying price
        for(int i=0; i<=n; i++){
            //selling price
            for(int j=i+1; j<=n; j++){
                int p = prices[j] - prices[i];
                if(p > profit)
                    profit = p;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
 //       int[] prices = {7,6,4,3,1};
        int[] prices = {7,1,5,3,5,4};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit(prices));
    }
}
