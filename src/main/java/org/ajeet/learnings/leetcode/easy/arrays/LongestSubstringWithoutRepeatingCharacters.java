package org.ajeet.learnings.leetcode.easy.arrays;

import java.util.HashSet;
import java.util.Set;

public final class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0)
            return 0;

        Set<Character> cache = new HashSet<>();
        int result = 0;
        int j = 0;
        int i = 0;
        int n = s.length();

        while (i < n && j < n ) {
            if(!cache.contains(s.charAt(j))) {
                cache.add(s.charAt(j));
                j++;
                result = Math.max(result, j - i);
            } else {
                cache.remove(s.charAt(i++));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String  s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
