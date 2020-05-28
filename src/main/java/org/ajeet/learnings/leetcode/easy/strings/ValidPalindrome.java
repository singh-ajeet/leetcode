package org.ajeet.learnings.leetcode.easy.strings;

public final class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        if(s == null || s.isEmpty())
            return true;

        int i = 0;
        int j = s.length()-1;
        while (i<j) {
            if(!Character.isLetterOrDigit(s.charAt(i)))
                i++;
            else if(!Character.isLetterOrDigit(s.charAt(j)))
                j--;
            else {
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
