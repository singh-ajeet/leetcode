package org.ajeet.learnings.leetcode.easy.arrays;

public final class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3)
            return false;

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if(num <= first) {
                first = num;
            } else if(num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
/*
        int[] input1 = {1,2,3,4,5};
        System.out.println(increasingTriplet(input1));
        int[] input2 = {5,4,3,2,1};
        System.out.println(increasingTriplet(input2));
        int[] input3 = {5,4,3,4,5};
        System.out.println(increasingTriplet(input3));
        int[] input4 = {2,1,5,0,3};
        System.out.println(increasingTriplet(input4));
 */
        int[] input5 = {5,2,3,1,4};
        System.out.println(increasingTriplet(input5));
    }
}
