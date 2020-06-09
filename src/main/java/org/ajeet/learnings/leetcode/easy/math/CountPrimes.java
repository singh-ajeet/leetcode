package org.ajeet.learnings.leetcode.easy.math;

import java.util.Arrays;

public final class CountPrimes {

    private boolean isPrime(int n) {
        if(n == 1)
            return false;

        if(n ==2)
            return true;

        for(int i=2; i<= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public int countPrimes2(int n) {
        int count = 0;
        for (int i=1; i<n; i++) {
            if(isPrime(i))
                count++;
        }
        return count;
    }

    /**
     * Sieve of Eratosthenes
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        for (int i=2; i<=Math.sqrt(n); i++) {
            if(primes[i]){
                int x= i + i;
                for(int j= i*i; j <= n; j = j + i) {
                    primes[j] = false;
                }
            }
        }

        int count = 0;
        for (int i=2; i<n; i++) {
            if(primes[i])
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
