package org.ajeet.learnings.leetcode.easy.arrays;

import java.util.HashMap;
import java.util.Map;

public final class SingleNumber {

    //a⊕ b⊕ a = (a⊕ a)⊕ b = 0⊕ b=b
    public int singleNumber2(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int count = 1;
            if(cache.containsKey(nums[i])){
                count++;
            }
            cache.put(nums[i], count);
        }
        for(int i=0; i<nums.length; i++) {
            if(cache.get(nums[i]) == 1) {
                return nums[i];
            }
        }
        return 0;
    }
}
