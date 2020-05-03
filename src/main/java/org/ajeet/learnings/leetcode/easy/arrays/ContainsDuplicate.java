package org.ajeet.learnings.leetcode.easy.arrays;

import java.util.HashMap;
import java.util.Map;

public final class ContainsDuplicate {

    public boolean containsDuplicate2(int[] nums) {
        Map<Integer, Boolean> cache  = new HashMap<>();

        for (int i =0; i<nums.length; i++){
            if (cache.containsKey(nums[i]))
                return true;
            cache.put(nums[i], true);
        }
        return false;
    }
}
