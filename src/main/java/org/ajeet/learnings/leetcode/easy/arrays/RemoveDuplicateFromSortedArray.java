package org.ajeet.learnings.leetcode.easy.arrays;

public final class RemoveDuplicateFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 1; i< nums.length; i++){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }

        }
        return j+1;
    }

    public static void main(String[] args) {
        int i =2, j =2;
        int box_index = (i / 3 ) * 3 + j / 3;
        System.out.println(box_index);
      /*  int[] input = {1,1,2};
        System.out.println(new RemoveDuplicateFromSortedArray().removeDuplicates(input));
        for (int x: input){
            System.out.print(x + " ");
        }*/
    }
}
