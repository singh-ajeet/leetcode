package org.ajeet.learnings.leetcode.easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class IntersectionOfTwoArraysII {

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        List<Integer> intesected = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intesected.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[intesected.size()];
        int x =0;
        for (int num : intesected)
            result[x++] = num;
        return result;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cache = new HashMap<>();

        for (int num : nums1)
            cache.put(num, cache.getOrDefault(num, 0) + 1);

        List<Integer> intesected = new ArrayList<>();
        for (int num : nums2) {
            if (cache.containsKey(num)) {
                int count = cache.get(num);
                if(count > 0){
                    intesected.add(num);
                }
                cache.put(num, --count);
            }
        }
        int[] result = new int[intesected.size()];
        int i =0;
        for (int num : intesected)
            result[i++] = num;
        return result;
    }
}
