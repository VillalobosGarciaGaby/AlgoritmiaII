package Chocolate.DP;
import java.util.Arrays;

public class ChocolateDivider {

    static int[] dp;

    public static int maxPiecesOfChocolate(int N) {
        // Inicializamos la matriz de DP con -1
        dp = new int[N + 1];
        Arrays.fill(dp, -1);

        // Llamamos a la función divideChocolate con el valor de inicio igual a 1
        return divideChocolate(N, 1);
    }

    public static int divideChocolate(int n, int start) {
        // Si ya hemos calculado el resultado para esta longitud, lo retornamos
        if (dp[n] != -1) {
            return dp[n];
        }

        // Caso base: si la longitud es 0, retornamos 0
        if (n <= 0) return 0;

        int maxPieces = 0;
        for (int i = start; i <= n; i++) {
            int pieces = divideChocolate(n - i, i + 1);
            maxPieces = Math.max(maxPieces, 1 + pieces);
        }

        // Guardamos el resultado en la matriz de DP
        dp[n] = maxPieces;
        return maxPieces;
    }

    public static void main(String[] args) {
        System.out.println(maxPiecesOfChocolate(8)); // 3
        System.out.println(maxPiecesOfChocolate(5)); // 2
        System.out.println(maxPiecesOfChocolate(7)); // 3
        System.out.println(maxPiecesOfChocolate(12)); // 4
        System.out.println(maxPiecesOfChocolate(20)); // 5
        System.out.println(maxPiecesOfChocolate(30)); // 7
        System.out.println(maxPiecesOfChocolate(35)); // 7
        System.out.println(maxPiecesOfChocolate(40)); // 8
        System.out.println(maxPiecesOfChocolate(45)); // 9

    }
}
