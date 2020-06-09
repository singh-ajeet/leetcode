package org.ajeet.learnings.leetcode.easy.math;

import java.util.HashMap;
import java.util.Map;

public final class RomanToInteger {
    private static final Map<Character, Integer> values = new HashMap<>();

    static {
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
    }

    public int romanToInt(String s) {
        int result = 0;

        char[] chars = s.toCharArray();
        for(int i=0; i< s.length(); i++){
            int x = values.get(chars[i]);
            if(i+1<s.length() && values.get(chars[i]) < values.get(chars[i+1])){
                x = x * -1;
            }
            result = result + x;
        }

        return result;
    }
}
