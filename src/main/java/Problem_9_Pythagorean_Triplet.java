package main.java;

import java.util.ArrayList;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which: a^2 + b^2 = c^2
 * <p>
 * Example for 3, 4, 5:
 * 3^2 + 4^2 = 5^2
 * = 9 + 16
 * = 25
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * <p>
 * Find the product abc.
 */

public class Problem_9_Pythagorean_Triplet {

    public static void main(String[] args) {

        System.out.println(goldenTripletProduct(tripletsWithValidSum()));

    }

    public static int goldenTripletProduct(ArrayList<String> tripStrings) {
        int[] tmp = {0, 0, 0};

        for (String tripStr : tripStrings) {
            tmp[0] = Integer.parseInt(tripStr.split(",")[0]);
            tmp[1] = Integer.parseInt(tripStr.split(",")[1]);
            tmp[2] = Integer.parseInt(tripStr.split(",")[2]);

            if (isPythagoreanTriplet(tmp[0], tmp[1], tmp[2])) {
                return tmp[0] * tmp[1] * tmp[2];
            }
        }
        return 0;
    }

    public static boolean isPythagoreanTriplet(int a, int b, int c) {
        //verify that a < b < c
        if (a < b && b < c) {
            //verify that a^2 + b^2 = c^2
            if (a * a + b * b == c * c) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> tripletsWithValidSum() {
        ArrayList<String> triplets = new ArrayList<>();
        int a = 1, b = 2, c = 3;
        String tripStr;

        while (a < 1000) {
            while (b < 1000) {
                while (c < 1000) {
                    if (a + b + c == 1000) {
                        tripStr = (a + "," + b + "," + c);
                        triplets.add(tripStr);
                    }
                    c++;
                }
                c = 1;
                if (a + b + c == 1000) {
                    tripStr = (a + "," + b + "," + c);
                    triplets.add(tripStr);
                }
                b++;
            }
            b = 1;
            if (a + b + c == 1000) {
                tripStr = (a + "," + b + "," + c);
                triplets.add(tripStr);
            }
            a++;
        }
        return triplets;
    }

    /**
     *  TRIPLET SUM TO 1000 NOTES:
     *  c must be less than sqrt(1000)
     *  b must be less than c
     *  a must be less than b
     *  a + b must equal 1000
     */


}
