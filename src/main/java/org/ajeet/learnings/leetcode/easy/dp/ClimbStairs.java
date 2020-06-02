package org.ajeet.learnings.leetcode.easy.dp;

public final class ClimbStairs {

    /**
     * Recursion
     *
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if(n == 0 || n==1)
            return 1;
        return climbStairs1(n-1) + climbStairs(n-2);
    }

    /**
     * Dynamic programming
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n == 0 || n == 1)
            return 1;

        int ways1 = 1;
        int ways2 = 2;
        int i = 3;

        while(i <= n) {
            int tmp = ways1;
            ways1 = ways2;
            ways2 = tmp + ways2;
            i++;
        }
        return  ways2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(3));
        System.out.println(climbStairs(3));
    }
}
