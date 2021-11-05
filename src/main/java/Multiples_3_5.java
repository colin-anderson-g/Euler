package main.java;

public class Multiples_3_5 {

    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     *
     * Find the sum of all the multiples of 3 or 5 below 1000.
     */


    public static void main(String[] args) {
        int sumOfMultiples = 0;

        for(int num = 3; num < 1000; num++){
            if(num % 3 == 0 || num % 5 == 0){
                sumOfMultiples += num;
            }
        }
        System.out.println(sumOfMultiples);
    }

}
