package org.ajeet.learnings.leetcode.easy.strings;

public final class ReverseInteger {

    public static int reverse(int x) {
        if(x == Integer.MAX_VALUE || x == Integer.MIN_VALUE)
            return 0;

        int positive = Math.abs(x);
        if(positive < 10)
            return x;

        int result = 0;
        while (positive > 0) {
            int lastDigit = positive % 10;
            //To handle integer overflow
            if(result > Integer.MAX_VALUE /10)
                return 0;
            result*=10;
            //To handle integer overflow
            if(result > Integer.MAX_VALUE - lastDigit)
                return 0;

            result+=lastDigit;

            positive = positive /10;
         }
        return x > 0 ? result : -1 * result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(111));
        System.out.println(reverse(100));
        System.out.println(reverse(-100));
        System.out.println(reverse(-12));
        System.out.println(reverse(1534236469));
    }
}
