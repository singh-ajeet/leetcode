package org.ajeet.learnings.leetcode.medium.dp;

public final class TargetSum {

    public static int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, S, 0, nums.length, 0);
    }

    private static int findTargetSumWays(int[] nums, int s, int i, int n, int tmp) {
        if(i == n) {
            if(tmp == s)
                return 1;
            else
                return 0;
        }
        return findTargetSumWays(nums, s, i+1,n, tmp+nums[i])
                + findTargetSumWays(nums, s, i+1,n, tmp-nums[i]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(arr, 3));
    }
}
