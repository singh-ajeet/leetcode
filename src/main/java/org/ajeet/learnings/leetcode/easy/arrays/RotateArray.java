package org.ajeet.learnings.leetcode.easy.arrays;

import java.util.Arrays;

public final class RotateArray {

    public void rotate(int[] nums, int k) {
        int l = nums.length;
        int[] rotated = new int[l];
        for (int i =0; i< l; i++)
            rotated[(i+k)%l] = nums[i];
        for (int i =0; i< l; i++)
            nums[i] = rotated[i];
    }

    public void rotate2(int[] nums, int k) {
        int l = nums.length;
        k = k %l;
        reverse(nums, 0, l);
        //Reverse two half, <LEFT>,K,<RIGHT>
        reverse(nums, 0, k);
        reverse(nums, k, l);

    }
    private void reverse(int[] nums, int from, int to){
        int l = nums.length;
        //Reverse array
        int i = from;
        int j = to-1;
        while(j > i){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        // int[] nums = {1,2,3,4,5,6,7};
        // int[] nums = {-1};
        int[] nums = {1,2};
        new RotateArray().rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
