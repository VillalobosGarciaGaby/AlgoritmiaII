package org.example;
import java.util.Scanner;

public class PracticeA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int v = scanner.nextInt();

            long[][] a = new long[51][51];

            a[n][1] = v;

            for (int i = n; i >= 1; i--) {
                for (int j = 1; j <= n; j++) {
                    if (j == 1 && i == n)
                        continue;

                    if (i >= j) {
                        long left = 0, right = 0;

                        for (int k = i + 1; k <= n; k++)
                            left = Math.max(a[k][1] + a[k][j], left);

                        for (int k = 1; k <= n && k < i + j; k++)
                            right = Math.max(a[i][k] + a[n][k], right);

                        a[i][j] = left + right;
                    } else {
                        for (int k = i; k < i + j && k <= n; k++)
                            a[i][j] = Math.max(a[i][k] + a[k + 1][j], a[i][j]);
                    }
                }
            }

            System.out.println(a[1][n]);
        }
    }
}