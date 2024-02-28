package org.example;

public class EditDistane {
    public static int minDistance(String word1, String word2) {
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

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= word2.length(); j++) {
                System.out.print(dp[i][j]+" ");
            } System.out.println();
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Words: gatos and patos" );
        int procesessNumber = minDistance("gato", "pato");
        System.out.println("Result:" + procesessNumber);
        System.out.println();


    }
}