package org.ajeet.learnings.leetcode.easy.strings;

public final class ReverseString {

    public static void reverseString(char[] chars) {
        if(chars == null || chars.length < 2) {
            return;
        }

        int start = 0;
        int end  = chars.length -1;
        while (start < end) {
            swap(start, end, chars);
            start++;
            end--;
        }
    }

    private static void swap(int i, int j, char[] chars){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
