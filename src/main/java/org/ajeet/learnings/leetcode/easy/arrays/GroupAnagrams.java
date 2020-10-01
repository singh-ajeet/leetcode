package org.ajeet.learnings.leetcode.easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return Collections.EMPTY_LIST;

        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return groups.values().stream().
                collect(Collectors.toCollection(ArrayList::new));
    }

    private static String getKey(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String[]  strs = {"eat","tea","tan","ate","nat","bat" };
        System.out.println(groupAnagrams(strs));
    }
}
