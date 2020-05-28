package org.ajeet.learnings.leetcode.easy.strings;

import java.util.HashMap;
import java.util.Map;

public final class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Integer> counts1 = getCount(s);
        Map<Character, Integer> counts2 = getCount(t);

        if(counts1.size() != counts2.size())
            return false;

        for(Map.Entry<Character, Integer> entry : counts1.entrySet()) {
            if (!counts2.containsKey(entry.getKey()))
                return false;

            int otherValue = counts2.get(entry.getKey());

            if(entry.getValue() != otherValue)
                return false;
        }
       return true;
    }

    private static Map<Character, Integer> getCount(String s){
        Map<Character, Integer> counts = new HashMap<>();
        for(char ch : s.toCharArray()){
            int count = counts.getOrDefault(ch, 0) + 1;
            counts.put(ch, count);
        }
        return counts;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram( "anagram", "nagaram"));
        System.out.println(isAnagram( "rat", "car"));
    }
}
