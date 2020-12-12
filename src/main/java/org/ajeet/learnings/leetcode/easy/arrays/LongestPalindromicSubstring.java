package org.ajeet.learnings.leetcode.easy.arrays;

public final class LongestPalindromicSubstring {

    public static int length(String s) {
        int len = 0;
        if(s == null || s.length() == 0)
            return len;

        for(int i=0; i< s.length() - 1; i++) {
            int len1 = palindromeLength(i, i, s);
            int len2 = palindromeLength(i, i+1, s);
            int tmp = Math.max(len1, len2);
            len = Math.max(tmp, len);
        }
        return len;
    }

    private static int palindromeLength(int start, int end, String s) {
        while(end < s.length() && start >=0 && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end -start -1;
    }


    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static void main(String[] args) {
        System.out.println(length("abaac"));
        System.out.println(longestPalindrome("abaac"));
    }
}
