package org.ajeet.learnings.leetcode.easy.design;

import java.util.Random;

public final class ShuffleAnArray {
    private final int[] original;
    private final int[] shuffled;
    private final Random random = new Random();

    public ShuffleAnArray(int[] nums) {
        original = nums;
        shuffled = new int[original.length];
        for (int i=0; i< shuffled.length; i++) {
            shuffled[i] = original[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for (int i=0; i< shuffled.length; i++) {
            shuffled[i] = original[i];
        }
        return shuffled;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = shuffled.length;
        for(int i=0; i<n; i++) {
            swap(i, random.nextInt(n-i) + i);
        }
        return shuffled;
    }

    private void swap(int i, int j) {
        int tmp = shuffled[j];
        shuffled[j] = shuffled[i];
        shuffled[i] = tmp;
    }

}
