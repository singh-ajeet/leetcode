package org.ajeet.learnings.leetcode.easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            int diff = target-nums[i];
            if(cache.containsKey(nums[i])) {
                return new int[]{ cache.get(nums[i]),i};
            } else {
                cache.put(diff, i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        System.out.println(Arrays.toString(new TwoSum().twoSum(input, 9)));
    }
}
