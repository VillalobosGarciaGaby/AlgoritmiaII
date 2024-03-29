package org.example.Test;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Podemos utilizar tanto bottom up y top down, ya que gracias a esta funcion dp[n] = function(n - 1, dp) + function(n - 2, dp)
 *          + function(n - 3, dp);
 */
public class Question1 {
    static final int SIZE = 100;
    static int[] result = new int[SIZE];
    public static void initializeArray() {
        Arrays.fill(result, -1);
    }

    public static int fibonacciDp2(int n) {// n=4; memoization = [0,0,0,0,0]
        // n = 3; memoization = [0,0,0,0,0]
        if (result[n] == -1) {
            if (n<=1)
                result[n] = n;
            else
                result[n] = fibonacciDp2(n-1) + fibonacciDp2(n-2)+ fibonacciDp2(n-3);
        }

        return result[n];
    }

    public static int fibonacciDp(int n, int[] memoization) {// n=4; memoization = [0,0,0,0,0]
        // n = 3; memoization = [0,0,0,0,0]
        if (n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        if (memoization[n] != 0)
            return memoization[n];
        memoization[n] = fibonacciDp(n-1, memoization) + fibonacciDp(n-2, memoization) + fibonacciDp(n-3, memoization);

        return memoization[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] memoization = new int[n + 1];
        initializeArray();
//        var result = fibonacciDp(n, memoization);
        System.out.printf("Fibonacci(%d) = %d\n", n,  fibonacciDp(n, memoization));
    }
}

