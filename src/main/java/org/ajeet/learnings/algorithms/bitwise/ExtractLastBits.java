package org.ajeet.learnings.algorithms.bitwise;

public class ExtractLastBits {

    public static int last2(int n){
        int mask = 0b11;
        return n & mask;
    }


    public static void main(String[] args) {
        long x = 241294492511762325l;
        long shifted = x >> 46;
        long mask = 0b111111111111111;
        System.out.println(shifted & mask);
    }
}
