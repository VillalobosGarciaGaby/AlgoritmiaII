package GreedyTask;
import java.util.Arrays;
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

        Arrays.sort(canisters);
        reverse(canisters);

        int trips = 0;
        int i = 0;
        while (i < n) {
            int totalVolume = 0;
            int carriedCans = 0;
            while (i < n && totalVolume + canisters[i] <= k && carriedCans < 2) {
                totalVolume += canisters[i];
                carriedCans++;
                i++;
            }
            trips++;
        }
        if (canisters[n - 1] > k) {
            System.out.println("Impossible");
        } else {
            System.out.println(trips);
        }

        scanner.close();
    }

    private static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
