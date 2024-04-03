package Test3.Dp;

import java.util.Scanner;

public class DPMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberFood = scanner.nextInt();
        int timeMax = scanner.nextInt();

        int[] meals = new int[numberFood];
        for (int i = 0; i < numberFood; i++) {
            meals[i] = scanner.nextInt();
        }

        dpMax(numberFood, timeMax, meals);
    }

    /**
     * Calculates the maximum number of meals that can be consumed within a given time limit.
     *
     * @param numberFood The number of available food options.
     * @param timeMax The maximum time limit.
     * @param meals An array representing the time required for each food option.
     */
    public static void dpMax(int numberFood, int timeMax, int[] meals){
        int[][] dp = new int[numberFood + 1][timeMax + 1];

        for (int i = 1; i <= numberFood; i++) {
            for (int j = 1; j <= timeMax; j++) {
                if (meals[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - meals[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[numberFood][timeMax]);
    }
}


