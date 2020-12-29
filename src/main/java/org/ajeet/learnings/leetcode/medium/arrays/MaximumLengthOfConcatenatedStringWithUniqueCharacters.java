package org.ajeet.learnings.leetcode.medium.arrays;

import java.util.Arrays;
import java.util.List;

public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {

    public static int maxLength(List<String> arr) {
        if(arr == null || arr.size() == 0){
            return 0;
        }

        int[] maxLength = new int[1];
        maxLength(arr, 0, "", maxLength);

        return maxLength[0];
    }

    private static void maxLength(List<String> arr, int index, String current, int[] maxLength) {
        if(index == arr.size()){
            int length = uniqueLength(current);

            if(length > maxLength[0]){
                maxLength[0] = length;
            }
            return;
        }

        int length = uniqueLength(current);

        if(length == -1){
            maxLength(arr, index+1, "", maxLength);
        } else {
            if(length > maxLength[0]){
                maxLength[0] = length;
            }

            maxLength(arr, index+1, current, maxLength);
            maxLength(arr, index+1, current + arr.get(index), maxLength);
        }
    }

    private static int uniqueLength(String str){
        boolean[] chars = new boolean[26];

        for(char ch : str.toCharArray()){
            int index = ch - 'a';
            if(chars[index]){
                return -1;
            }
            chars[index] = true;
        }

        return str.length();
    }

    public static void main(String[] args) {
        List<String> arr  = Arrays.asList("un","iq","ue");
        System.out.println(maxLength(arr));
    }
}
