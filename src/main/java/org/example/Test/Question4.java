package org.example.Test;

public class Question4 {
    public static int minRegalosAMover(int[] regalos) {
        int n = regalos.length;
        int[] dp = new int[n];
        dp[0] = 0; // No hay regalos para mover para el primer regalo

        int valorMaximo = regalos[0]; // Valor máximo visto hasta ahora
        for (int i = 1; i < n; i++) {
            if (regalos[i] > valorMaximo) {
                dp[i] = dp[i - 1] ;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            valorMaximo = Math.max(valorMaximo, regalos[i]); // Actualizar valorMaximo
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] regalos1 = {1, 12, 5, 31};
        int[] regalos2 = {30, 21, 15, 12, 4};

        System.out.println("Mínimo de regalos a mover para el ejemplo 1: " + minRegalosAMover(regalos1));
        System.out.println("Mínimo de regalos a mover para el ejemplo 2: " + minRegalosAMover(regalos2));
    }
}