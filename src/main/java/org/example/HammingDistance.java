package org.example;

public class HammingDistance {
    public static int hammingDistance(String A, String B) {
        int m = A.length();
        int n = B.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String A = "abcde";
        String B = "bcdef";
        System.out.println("Distancia de Hamming entre '" + A + "' y '" + B + "' es: " + hammingDistance(A, B));
    }
}
