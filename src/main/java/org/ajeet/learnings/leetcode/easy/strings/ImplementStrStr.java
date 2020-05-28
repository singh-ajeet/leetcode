package org.ajeet.learnings.leetcode.easy.strings;

public final class ImplementStrStr {

    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.isEmpty())
            return 0;

        if(haystack.length() < needle.length())
            return -1;

        for(int i=0; i<= haystack.length() - needle.length(); i++) {
            int j = 0;
            int k = i;
            while (j<needle.length() && haystack.charAt(k)==needle.charAt(j)){
                j++;
                k++;
            }
            if(j == needle.length())
                return i;
        }
        return -1;

    }

    public static void main(String[] args) {
       System.out.println(strStr("hello", "ll"));
       System.out.println(strStr("aaaaa", "baa"));
       System.out.println(strStr("a", "a"));
    }
}
