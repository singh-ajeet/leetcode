package org.ajeet.learnings.leetcode.easy.dp;

public final class HouseRobber {

    public static int rob2(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1)
            return nums[0];

        if(nums.length ==2)
            return Math.max(nums[0], nums[1]);

        int minus2 = nums[0];
        int minus1 = Math.max(nums[0], nums[1]);
        int sum = 0;
        for(int i=2; i<nums.length; i++){
            sum = Math.max(nums[i] + minus2, minus1);
            minus2 = minus1;
            minus1 = sum;
        }

        return sum;
    }


    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1)
            return nums[0];

        if(nums.length ==2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] h = {2,4,8,9,9,3};
       // int[] h = {1,2,3,1};
       // int[] h = {2,1,1,2};
        System.out.println(rob2(h));
    }
}
