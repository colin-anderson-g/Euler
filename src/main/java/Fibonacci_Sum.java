package main.java;

public class Fibonacci_Sum {

    public static void main(String[] args) {
        int sumOfEvens = 0;
        int[] vals = {0, 1, 1};

        while(vals[2] < 4000000){
            vals[0] = vals[1];
            vals[1] = vals[2];
            vals[2] = vals[0] + vals[1];

            if(vals[2] % 2 == 0){
                sumOfEvens += vals[2];
            }
        }

        System.out.println(sumOfEvens);
    }


}
