package org.ajeet.learnings.leetcode.easy.arrays;

import java.util.Arrays;

public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        if(arr == null || arr.length == 0){
            return;
        }

        int n = arr.length -1;

        int count = 0;
        for(int i =0; i<= n; i++){
            if(arr[i] == 0){
                count++;
            }
        }

        for(int i = n-count; i>=0; i--){
            if(arr[i] == 0){
                int j = i + count;
                if(j < arr.length){
                    arr[j] = 0;
                }
                if(j+1 < arr.length){
                    arr[i+count+1] = 0;
                }

            } else {
                int j = i + count;

                if(j < arr.length && j >= 0){
                    arr[j] = arr[i];
                }
            }
            count--;
        }
    }

    public static void main(String[] args) {
        int[] input = {1,0,2,3,0,4,5,0};
        System.out.println(Arrays.toString(input));

        duplicateZeros(input);

        System.out.println(Arrays.toString(input));
    }
}
