package org.ajeet.learnings.leetcode.easy.dp;

public final class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
       int tmpSum = nums[0];
       int sum = nums[0];

       for (int i=1; i< nums.length; i++) {
           tmpSum = Math.max(nums[i], tmpSum + nums[i]);
           sum = Math.max(tmpSum, sum);
       }
       return sum;
    }

    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
