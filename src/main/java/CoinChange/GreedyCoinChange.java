package Greedy.CoinChange;
import java.util.Arrays;

public class GreedyCoinChange {

    public static int countWays(int[] coins, int amount) {
        Arrays.sort(coins);

        int ways = 0;
        int index = coins.length - 1;

        while (amount > 0 && index >= 0) {
            if (coins[index] <= amount) {
                int numCoins = amount / coins[index];
                ways += numCoins;
                amount -= numCoins * coins[index];
            }
            index--;
        }

        return amount == 0 ? ways : 0;
    }

    public static void main(String[] args) {
        int[] coins = {50, 25, 10, 5, 1};
        int amount1 = 11;
        int amount2 = 26;

        int ways1 = countWays(coins, amount1);
        int ways2 = countWays(coins, amount2);

        System.out.println("Formas de hacer cambios para " + amount1 + " centavos: " + ways1);
        System.out.println("Formas de hacer cambios para " + amount2 + " centavos: " + ways2);
    }
}
