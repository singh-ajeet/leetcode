package org.ajeet.learnings.leetcode.easy.math;

public final class ReverseBits {

    public static int reverseBits(int n) {
        int reversed = 0;

        int x = 32;
        while (x-- != 0) {
            //Extract last bit
            int lastBit = n & 1;
            reversed = reversed << 1;
            reversed = reversed | lastBit;

            n = n >> 1;
           // System.out.println(Integer.toBinaryString(reversed));
        }

        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
}
