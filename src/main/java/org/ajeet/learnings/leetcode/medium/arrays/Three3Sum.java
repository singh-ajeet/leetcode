package org.ajeet.learnings.leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class Three3Sum {

    public static ArrayList<int[]> threeSum(int[] arr) {
        ArrayList<int[]> results = new ArrayList<int[]>();

        Arrays.sort(arr);

        for (int i = 0; i <= arr.length - 3; i++) {
            if (i == 0 || arr[i] > arr[i - 1]) {
                int start = i + 1;
                int end = arr.length - 1;

                while (start < end) {
                    if (arr[i] + arr[start] + arr[end] == 0) {
                        results.add(new int[] {arr[i], arr[start], arr[end]});
                    }

                    if (arr[i] + arr[start] + arr[end] < 0) {
                        int currentStart = start;
                        while (arr[start] == arr[currentStart] && start < end) {
                            start++;
                        }
                    } else {
                        int currentEnd = end;
                        while (arr[end] == arr[currentEnd] && start < end) {
                            end--;
                        }
                    }
                }
            }
        }

        return results;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for (int i =0; i<nums.length-3; i++) {
            if(i ==0 || nums[i] > nums[i-1]){
                int start = i+1;
                int end = nums.length-1;

                while (start < end){
                    int sum = nums[i] + nums[start] + nums[end];
                    if(sum == 0){
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    }

                    if(sum < 0){
                        int currentStart = start;
                        while ((nums[currentStart] == nums[start]) && start < end){
                            start++;
                        }
                    } else {
                        int currentEnd = end;
                        while ((nums[currentEnd] == nums[end]) && start < end){
                            end--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);
        queue.offer(0);
        System.out.println(threeSum(new int[] {0,0,0}));
    }
}
