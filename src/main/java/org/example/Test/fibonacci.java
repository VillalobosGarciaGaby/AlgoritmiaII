package org.example.Test;

/**
 * Prueba con el codigo dado
 */
public class fibonacci {
    private static int function(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        dp[n] = function(n - 1, dp) + function(n - 2, dp) + function(n - 3, dp);

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10; // El número de Fibonacci que quieres calcular
        int[] dp = new int[n + 1]; // Array para memoización

        int result = function(n, dp);

        System.out.println("El " + n + "-ésimo número de Fibonacci es: " + result);
    }
}
