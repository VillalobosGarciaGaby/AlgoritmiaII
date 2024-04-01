package Chocolate.Greedy;

import java.io.*;

public class ChocolateBarGreedy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(maxPiecesOfChocolate(N)));
        br.close();
        bw.close();
    }

    /**
     * Este método calcula el número máximo de piezas de chocolate que se pueden obtener
     * dado un tamaño de barra de chocolate.
     * @param n El tamaño de la barra de chocolate.
     * @return El número máximo de piezas de chocolate que se pueden obtener.
     */
    private static int maxPiecesOfChocolate(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return 1;

        int partialSum = 0;
        int portions = 0;

        for (int i = 1; i <= n; i++) {
            if ((n - partialSum) >= i + 1) {
                partialSum += i;
                portions += 1;
            }
            else break;
        }
        return portions;
    }

}