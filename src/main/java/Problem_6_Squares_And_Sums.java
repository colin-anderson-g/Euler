package main.java;

/**
 * The sum of the squares of the first ten natural numbers is 385
 *
 * The square of the sum of the first ten natural numbers is 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 2640
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */

public class Problem_6_Squares_And_Sums {

    public static void main(String[] args) {
        System.out.println(sumOfSquares(1, 100) - squareOfSum(1, 100));
    }

    //find the sum of squares for a given range
    public static int sumOfSquares(int bottom, int top) {
        int sum = 0;
        while(bottom <= top) {
            sum += bottom * bottom;
            bottom++;
        }
        return sum;
    }

    //find the square of the sum for a given range
    public static int squareOfSum(int bottom, int top) {
        int sum = 0;

        while(bottom <= top) {
            sum += bottom;
            bottom++;
        }

        return sum * sum;
    }

}
