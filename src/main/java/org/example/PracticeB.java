package org.example;
import java.util.Scanner;

public class PracticeB {
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int knapsack(int capacity, int[] weights, int[] values, int itemCount, int[][] memo) {
        if (itemCount == 0 || capacity == 0)
            return 0;

        if (memo[itemCount][capacity] != -1)
            return memo[itemCount][capacity];

        if (weights[itemCount - 1] > capacity)
            return memo[itemCount][capacity] = knapsack(capacity, weights, values, itemCount - 1, memo);
        else
            return memo[itemCount][capacity] = max(values[itemCount - 1] + knapsack(capacity - weights[itemCount - 1], weights, values, itemCount - 1, memo),
                    knapsack(capacity, weights, values, itemCount - 1, memo));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases, itemCount;
        testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            itemCount = scanner.nextInt();
            int[] values = new int[itemCount];
            int[] weights = new int[itemCount];

            for (int j = 0; j < itemCount; j++) {
                values[j] = scanner.nextInt();
                weights[j] = scanner.nextInt();
            }

            int bags, capacity, total = 0;
            bags = scanner.nextInt();

            for (int k = 0; k < bags; k++) {
                capacity = scanner.nextInt();
                int[][] memo = new int[itemCount + 1][capacity + 1];
                for (int[] row : memo)
                    java.util.Arrays.fill(row, -1);
                total += knapsack(capacity, weights, values, itemCount, memo);
            }
            System.out.println(total);
        }
    }
}