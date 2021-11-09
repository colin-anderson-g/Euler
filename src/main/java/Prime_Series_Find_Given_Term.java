package main.java;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */

public class Prime_Series_Find_Given_Term {

    public static void main(String[] args) {

        System.out.println(getNthPrimeNumber(10_001));

    }

    public static int getNthPrimeNumber(int numberOfTerms) {
        int i = 1;
        int number;
        int termCounter = 0;

        //loop until nth term is reached
        while(termCounter <= numberOfTerms) {

            //loop to check remainder against values less than current number
            int counter = 0;
            for(number = i; number >= 1; number--) {

                //count evenly divisible cases
                if(i % number == 0) {
                    counter = counter + 1;
                }
            }

            //a prime number can only have 2 evenly divisible cases
            //it is only divisible by itself(case 1) and one(case 2)
            if (counter == 2) {
                termCounter++;
                if(termCounter == numberOfTerms){
                    return i;
                }
            }
            i++;
        }

        //default case return 1
        return 1;
    }

}
