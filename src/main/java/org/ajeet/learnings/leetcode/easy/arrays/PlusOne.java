package org.ajeet.learnings.leetcode.easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class PlusOne {

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length -1; i >= 0; i--){
            if(digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        //If all digits are 9 than we will be here.
        int[] resultArray = new int[digits.length + 1];
        resultArray[0] = 1;
        return resultArray;
    }

    public int[] plusOne(int[] digits) {
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 1;
        for (int i = digits.length -1; i >= 0; i--){
            int d = carry + digits[i];
            if(d == 10) {
                result.addFirst(0);
                if(i == 0)
                    result.addFirst(1);
                carry = 1;
            } else {
                result.addFirst(d);
                carry = 0;
            }
        }

        int[] resultArray = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    public static void main(String[] args) {
      //  int[] input = {9};
      //  int[] input = {1,2,3};
        int[] input = {9,9,9};
        System.out.println(Arrays.toString(new PlusOne().plusOne(input)));
    }
}
