package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PracticeF {
    static int numberOfCars, cars[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(testCases-- > 0) {
            String line;
            while((line = br.readLine()).isEmpty());
            numberOfCars = Integer.parseInt(line.trim());
            cars = new int[numberOfCars];

            for (int i = 0; i < numberOfCars; i++) {
                while((line = br.readLine()).isEmpty());
                cars[i] = Integer.parseInt(line.trim());
            }

            int[] increasingLIS = new int[numberOfCars];
            int[] decreasingLDS = new int[numberOfCars];

            findLongestSubsequence(increasingLIS);

            for (int i = 0; i < numberOfCars; i++) {
                cars[i] *= -1;
            }

            findLongestSubsequence(decreasingLDS);

            int ans = 0;

            for (int i = 0; i < numberOfCars; i++) {
                ans = Math.max(ans, increasingLIS[i] + decreasingLDS[i] - 1);
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static void findLongestSubsequence(int[] memo) {
        Arrays.fill(memo, 1);

        for (int i = numberOfCars - 1; i >= 0; i--) {
            int max = 0;

            for (int j = i + 1; j < numberOfCars; j++) {
                if(cars[j] > cars[i]) {
                    max = Math.max(max, memo[j]);
                }
            }

            memo[i] += max;
        }
    }
}