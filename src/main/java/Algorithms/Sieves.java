package main.java.Algorithms;

public class Sieves {

    //main method for testing
    public static void main(String[] args) {

        //boolean[] primes = Sieves.euler(2_000_000);

        boolean[] pbTerms = primesBelow(2000000);
        boolean[] terms = euler(2000000);


    }


    /**
     * Sieve of Eratosthenes:
     * This is the original Prime Sieve algorithm
     * Subsequent sieves in this class are faster
     *
     * @param n
     * @return boolean[]
     */
    public boolean[] eratosthenes(int n) {
        boolean[] primes = new boolean[n];

        // assume that all numbers are prime within given range
        for (int i = 2; i <= n; i++) {

            //consider only odd numbers (and 2)
            if (i % 2 != 0 || i == 2) {
                primes[i] = true;
            }

        }

        // for all numbers in range, starting from 2
        for (int i = 2; i * i < n; i++) {

            // mark natural multiples of i as non-prime
            if (primes[i]) {
                for (int j = i; i * j <= n; j++) {
                    primes[i * j] = false;
                }
            }
        }
        return primes;
    }

    /**
     * Sieve of Euler
     * First, make a list of numbers from 2, as large as you wish; call the maximum number n.
     * ||  oddNaturalNumbersUpTo(int upperBound)  ||
     * <p>
     * Second, extract the first number from the list, make a new list in which each element of the original list, including the first, is multiplied by the extracted first number.
     * ||  removeMultiplesOfIndexFromTerms(boolean[] terms, int index)  ||
     * <p>
     * Third, “subtract” the new list from the original, keeping in an output list only those numbers in the original list that do not appear in the new list.
     * ||  Above named method covers this step  ||
     * <p>
     * Fourth, output the first number from the list, which is prime, and repeat the second, third and fourth steps on the reduced list excluding its first element, continuing until the input list is exhausted.
     * ||  Call removeMultiplesOfIndexFromTerms() in loop for each index in terms
     *
     * @param upperBound
     * @return BigInteger[]
     */
    public static boolean[] euler(int upperBound) {
        boolean[] terms = oddNaturalNumbersUpTo(upperBound);


        for (int index = 3; index < terms.length; index += 2) {
            terms = removeMultiplesOfIndexFromTerms(terms, index);
            if (!terms[5]) {
                System.out.println("Something fucky going on at terms[index]");
            }
        }

        for (int i = 0; i < terms.length; i++) {
            if (terms[i]) {
                System.out.print(i + ", ");
            }
        }

        return terms;
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

    //returns boolean array of size where odd indices are marked true
    public static boolean[] oddNaturalNumbersUpTo(int upperBound) {
        boolean[] terms = new boolean[upperBound];

        for (int i = 2; i < upperBound; i++) {
            if (i % 2 != 0) {
                terms[i] = true;
            }
        }
        terms[2] = true;

        return terms;
    }

    //returns boolean array of size where even indices are marked true
    public static boolean[] evenNaturalNumbersUpTo(int upperBound) {
        boolean[] terms = new boolean[upperBound];

        for (int i = 2; i < upperBound; i++) {
            //consider only even numbers
            if (i % 2 == 0) {
                terms[i] = true;
            }
        }

        return terms;
    }

    //returns boolean array of size where all indices are marked true
    public static boolean[] naturalNumbersUpTo(int upperBound) {
        boolean[] terms = new boolean[upperBound];

        for (int i = 2; i < upperBound; i++) {
            terms[i] = true;
        }

        return terms;
    }

    public static boolean[] removeMultiplesOfIndexFromTerms(boolean[] terms, int index) {
        //remove multiples of given index from terms
        if (terms[index]) {
            for (int y = index; y < terms.length; y += 2) {
                if (y * index < terms.length - 1 && y * index >= y && terms[y * index]) {
                    terms[y * index] = false;
                }
            }
        }
        return terms;
    }

}
