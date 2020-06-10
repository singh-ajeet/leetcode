package org.ajeet.learnings.leetcode.easy.math;

public final class MissingNumber {

    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum+=n;
        }

        int sum2 = 0;
        for(int i=1; i<=nums.length; i++) {
            sum2+=i;
        }

        return sum2 - sum;
    }
}
