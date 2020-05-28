package org.ajeet.learnings.leetcode.easy.strings;

public final class StringToInteger {

    public static int myAtoi(String str) {
        if(str == null  || str.isEmpty())
            return 0;

        int result = 0;
        int i = 0;
        //Avoid initial whitespaces
        while(i<str.length() && str.charAt(i)==' '){i++;}
        //If all whitespaces
        if(i == str.length())
            return 0;
        //Handle signs
        boolean negative = false;
        if(str.charAt(i) == '+') {
            i++;
        }
        else if(str.charAt(i) == '-') {
            negative = true;
            i++;
        }
        //Parse number
        for(int j=i; j<str.length(); j++) {
            if(!Character.isDigit(str.charAt(j)))
                break;
            if(result > Integer.MAX_VALUE / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result*10;
            int digit = Character.getNumericValue(str.charAt(j));
            if(result > Integer.MAX_VALUE - digit) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result + digit ;
        }
        return negative ? -1 * result : result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(" "));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("words and 987"));
    }
}
