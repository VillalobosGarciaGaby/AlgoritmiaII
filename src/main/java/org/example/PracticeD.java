package org.example;

import java.util.*;

public class PracticeD {
    static int[] coins = {50, 25, 10, 5, 1};
    static int[][] memo;

    public static int waysToMakeChange(int amount) {
        memo = new int[amount + 1][coins.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return makeChange(amount, 0);
    }

    public static int makeChange(int amount, int coinIndex) {
        if (amount == 0) return 1;
        if (coinIndex >= coins.length) return 0;
        if (memo[amount][coinIndex] != -1) return memo[amount][coinIndex];

        int ways = 0;
        for (int i = 0; i * coins[coinIndex] <= amount; i++) {
            int remainingAmount = amount - i * coins[coinIndex];
            ways += makeChange(remainingAmount, coinIndex + 1);
        }

        memo[amount][coinIndex] = ways;
        return ways;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int amount = scanner.nextInt();
            int ways = waysToMakeChange(amount);
            System.out.println(ways);
        }
        scanner.close();
    }
}