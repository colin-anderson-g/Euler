package main.java;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class Problem_4_Largest_Palindrome_Product {

    public static void main(String[] args) {

        ArrayList<Integer> palindromeMultiples;
        int index = 0;
        palindromeMultiples = palindromeMultiplesOfThreeDigitNumbers();

        for (int number : palindromeMultiples) {
            if(isPalindrome(number)){
                palindromeMultiples.set(index++, number);
            }
        }

        verifyFindLargest();
        System.out.println(findLargest(palindromeMultiples));

    }

    public static int findLargest(ArrayList<Integer> values) {
        int largest = 0;

        for(int index = 0; index < values.size(); index++) {
            if(values.get(index) > largest) {
                largest = values.get(index);
            }
        }
        return largest;
    }

    public static boolean isPalindrome(int number) {

        String palinString = Integer.toString(number);
        palinString.toCharArray();

        int indexUp = 0 , indexDwn = palinString.toCharArray().length - 1;

        while(indexUp <= indexDwn) {
            if(palinString.toCharArray()[indexUp] != palinString.toCharArray()[indexDwn]){
                return false;
            }
            indexUp++;
            indexDwn--;
        }
        return true;
    }

    public static ArrayList<Integer> palindromeMultiplesOfThreeDigitNumbers() {
        ArrayList arrayOfMultiples = new ArrayList<Integer>();
        int lowerBound = 100;
        int upperBound = 999;
        int multiple = 0;

        while(upperBound >= lowerBound){
            multiple = upperBound * lowerBound++;
            if(isPalindrome(multiple)){
                arrayOfMultiples.add(multiple);
            }

            if(upperBound == lowerBound){
                upperBound -= 1;
                lowerBound = 100;
            }
        }

        return arrayOfMultiples;
    }

/**
 * NOTES:
 * Break into smaller problems
 * 1) Verify a palindrome number
 * 2) Find the largest number from a set (array)
 * 3) Multiply every 3-digit number combination?
 */

    /** ---TESTS--- */
    private static void verifyIsPalindrome() {
        if(isPalindrome(45054) && isPalindrome(89322398) && !isPalindrome(987111)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
    }

    private static void verifyFindLargest() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 100, 12340, 2, 35,34 ,80));

        if(findLargest(numbers) != 12340){
            System.out.println("Fail");
        } else {
            System.out.println("Pass");
        }
    }
}
