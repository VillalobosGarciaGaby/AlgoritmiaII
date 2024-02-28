package org.example.Test;

/**
 * Levenshtein Distance
 */
public class Question2EditDistance {

    public static int editDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;

        for (int j = 0; j <= word2.length(); j++) dp[0][j] = j;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                }
            }
        }

        // Imprime la tabla de gatos y patos
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= word2.length(); j++) {
                System.out.print(dp[i][j]+" ");
            } System.out.println();
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String str1 = "gatos";
        String str2 = "patos";

        int resultado = editDistance(str1, str2);
        System.out.println("Distancia de Edición entre '" + str1 + "' y '" + str2 + "': " + resultado);
        /**
         * Words: gatos and patos
         * 0 1 2 3 4 5
         * 1 1 2 3 4 5
         * 2 2 1 2 3 4
         * 3 3 2 1 2 3
         * 4 4 3 2 1 2
         * 5 5 4 3 2 1
         * Result:1
         */
    }
}
