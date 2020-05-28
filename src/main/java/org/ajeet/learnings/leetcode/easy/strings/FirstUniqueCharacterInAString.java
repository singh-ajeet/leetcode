package org.ajeet.learnings.leetcode.easy.strings;

import java.util.HashMap;
import java.util.Map;

public final class FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> cache = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars){
            int count = cache.getOrDefault(ch, 0) + 1;
            cache.put(ch, count);
        }

        for (int i=0; i< chars.length; i++){
            if (cache.get(chars[i]) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
