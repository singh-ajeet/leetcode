package org.ajeet.learnings.leetcode.easy.strings;

public final class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";

        StringBuilder builder = new StringBuilder("");
        int i=0;

        while(true) {
            if(i == strs[0].length())
                return builder.toString();

            char ch = strs[0].charAt(i);
            for(int j=1; j< strs.length; j++) {
                if(i ==strs[j].length() || strs[j].charAt(i) != ch) {
                    return builder.toString();
                }
            }
            i++;
            builder.append(ch);
        }
    }

    public static void main(String[] args) {
        String[] input1 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(input1));

        String[] input2 = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(input2));
    }

}
