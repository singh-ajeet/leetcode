package org.ajeet.learnings.leetcode.easy.arrays;

import java.util.Arrays;

public final class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int j=0;
        for (int i=0; i< nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
       // int[] input = {0,1,0,3,12};
        int[] input = {0,1,3,12};
        new MoveZeroes().moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }
}
