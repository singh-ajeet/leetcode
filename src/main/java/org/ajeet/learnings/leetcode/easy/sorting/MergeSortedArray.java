package org.ajeet.learnings.leetcode.easy.sorting;

import java.util.Arrays;

public final class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1; // after this position all elements are 0
        int j = n-1;
        int index = nums1.length-1;

        while(index >= 0) {
            if( j < 0) {
                nums1[index] = nums1[i];
                i--;
            } else if(i < 0) {
                nums1[index] = nums2[j];
                j--;
            } else if(nums1[i] > nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }
            index--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};

/*      int[] nums1 = {2,0};
        int[] nums2 = {1};

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
*/
        merge(nums1, 0, nums2,1);

        System.out.println(Arrays.toString(nums1));
    }
}
