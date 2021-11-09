package main.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

public class Problem_5_Smallest_Multiple {

    public static void main(String[] args) {
        final int lowerBound = 1;
        final int upperBound = 20;

        System.out.println(smallestDivisibleByRange(lowerBound, upperBound));

    }

    //This method would need to use long or BigInteger data types to work with larger ranges
    public static int smallestDivisibleByRange(int lowerBound, int upperBound) {
        int denominator;
        int numerator = lowerBound;
        int hits;
        long candidatePool = 999999999;
        boolean viable;

        //run candidates against one denominator
        while(numerator <= candidatePool) {
            //reset candidate
            denominator = lowerBound;
            hits = 0;
            viable = true;

            //run candidates against each denominator
            //denominators are numbers in the given range
            while(denominator <= upperBound && viable) {

                if(numerator % denominator == 0) {
                    //increment hits when a candidate divides evenly
                    hits++;
                } else {
                    viable = false;
                }

                //if the candidate has hits equal to the size of the range
                //then we know that this is the smallest numerator divisible
                //by every item in the given range
                if(hits == upperBound){
                    return numerator;
                }
                denominator++;
            }
            numerator++;

        }
        //return zero is none is found in range
        return 0;
    }

}


