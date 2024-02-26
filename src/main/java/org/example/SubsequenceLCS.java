package org.example;

//Cual es la subsecuencia? -> R: pple
public class SubsequenceLCS {
    public static String subsequence(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] lcsMatrix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
                } else {
                    lcsMatrix[i][j] = Math.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
                }
            }
        }
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                lcs.insert(0, A.charAt(i - 1));
                i--;
                j--;
            } else if (lcsMatrix[i - 1][j] > lcsMatrix[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.toString();
    }

    public static void main(String[] args) {
        String textA = "apple";
        String textB = "people";
        System.out.println("El LCS entre '" + textA + "' y '" + textB + "' es '" + subsequence(textA, textB) + "'");
    }
}
