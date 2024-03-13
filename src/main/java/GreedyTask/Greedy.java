package GreedyTask;

import java.util.Scanner;

public class Greedy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] canisters = new int[n];
        for (int i = 0; i < n; i++) {
            canisters[i] = scanner.nextInt();
        }

        int trips = 0, i = n - 1;
        while (i >= 0) {
            int totalVolume = 0, carriedCans = 0;
            while (i >= 0 && totalVolume + canisters[i] <= k && carriedCans < 2) {
                totalVolume += canisters[i];
                carriedCans++;
                i--;
            }
            if (totalVolume == 0) {
                System.out.println("Impossible");
                return;
            }
            trips++;
        }
        System.out.println(trips);

        scanner.close();
    }
}