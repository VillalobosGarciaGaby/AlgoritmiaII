package org.example;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class PracticeC {
    static Map<Integer, Integer> memoization = new HashMap<>();

    public static int calculateCycleLength(int n) {
        if (n == 1)
            return 1;

        if (memoization.containsKey(n))
            return memoization.get(n);

        int longitudCiclo;
        if (n % 2 == 0)
            longitudCiclo = 1 + calculateCycleLength(n / 2);
        else
            longitudCiclo = 1 + calculateCycleLength(3 * n + 1);

        memoization.put(n, longitudCiclo);

        return longitudCiclo;
    }

    public static int findMaxCycleLength(int inicio, int fin) {
        int longitudMaximaCiclo = 0;
        for (int num = Math.min(inicio, fin); num <= Math.max(inicio, fin); num++) {
            int longitudCiclo = calculateCycleLength(num);
            if (longitudCiclo > longitudMaximaCiclo)
                longitudMaximaCiclo = longitudCiclo;
        }
        return longitudMaximaCiclo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int inicio = scanner.nextInt();
            int fin = scanner.nextInt();
            int longitudMaximaCiclo = findMaxCycleLength(inicio, fin);
            System.out.println(inicio + " " + fin + " " + longitudMaximaCiclo);
        }

        scanner.close();
    }
}
