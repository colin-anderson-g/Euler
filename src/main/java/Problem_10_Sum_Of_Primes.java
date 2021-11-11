package main.java;

import java.math.BigInteger;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <p>
 * Find the sum of all the primes below two million.
 */

public class Problem_10_Sum_Of_Primes {

    public static void main(String[] args) {

        /** 1179908154 is not the correct answer */
        System.out.println(sumOfPrimesBelow(primesBelow(2000000)));

    }

    public static boolean[] primesBelow(int n) {
        boolean[] primes = new boolean[n];

        // assume that all numbers are prime within given range
        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }

        // for all numbers in range, starting from 2
        for (int i = 2; i * i < n; i++) {

            // mark natural multiples of i as non-prime
            if (primes[i]) {
                for (int j = i; i * j < n; j++) {
                    primes[i * j] = false;
                }
            }
        }
        return primes;
    }


    public static BigInteger sumOfPrimesBelow(boolean[] primes) {
        BigInteger sum = BigInteger.ZERO;

        for (int num = 0; num < primes.length; num++) {
            if (primes[num]) {
                sum = sum.add(BigInteger.valueOf(num));
            }
        }
        
        return sum;
    }


}
