package org.ajeet.learnings.algorithms.recursion;

public class Fibonacci {

    /**
     * Polynomial time
     * 
     * @param n
     * @return
     */
    public static int get1(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        return get1(n-1) + get1(n-2);
    }

    /**
     * Linear time
     *
     * @param n
     * @return
     */
    public static int get2(int n) {
        int first = 0;
        int second = 1;
        for(int i=2; i<= n; i++) {
            int tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(get2(7));
    }
}
