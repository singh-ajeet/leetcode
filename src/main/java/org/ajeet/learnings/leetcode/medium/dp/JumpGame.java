package org.ajeet.learnings.leetcode.medium.dp;

public final class JumpGame {

    public static boolean canJump(int[] nums) {
        int destination = nums.length-1;

        for(int i = nums.length-1; i>=0; i--){
            if(i+nums[i] >= destination)
                destination = i;
        }
        return destination == 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,8,2,0,0,1};
       // int[] nums = {2,3,1,1,4};
       // int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
