package org.ajeet.learnings.leetcode.easy.math;

import java.util.ArrayList;
import java.util.List;

public final class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for(int i =1; i<=n; i++){
            String str = "";
            if(i % 3 == 0) {
                str+="Fizz";
            }
            if(i % 5 == 0) {
                str+="Buzz";
            }

            if(str.equals("")) {
                str = Integer.toString(i);
            }

            result.add(str);
        }
        return result;
    }

    public List<String> fizzBuzz1(int n) {
        List<String> result = new ArrayList<>();
        for(int i =1; i<=n; i++){
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if(i % 5 == 0) {
                result.add("Buzz");
            } else if( i % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add(String.valueOf(i));

            }
        }
        return result;
    }

}
