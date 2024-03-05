package org.example.Kitt.Algoritmos;

/**
 * Clase que implementa el cálculo de la distancia de Levenshtein entre dos palabras.
 */
public class LevenshteinDistance {

    /**
     * Calcula la distancia de Levenshtein entre dos palabras.
     *
     * @param wordA Primera palabra.
     * @param wordB Segunda palabra.
     * @return La distancia de Levenshtein entre las dos palabras.
     */
    public static int levenshteinDistance(String wordA, String wordB) {
        if (wordA == null || wordB == null) {
            throw new IllegalArgumentException("Las palabras no pueden ser nulas");
        }

        char[] arrayA = wordA.toCharArray();
        char[] arrayB = wordB.toCharArray();
        int[][] mapComparator = new int[arrayA.length + 1][arrayB.length + 1];
        int upValue, leftValue, compareValue;

        for (int f = 1; f < arrayA.length + 1; f++) {
            mapComparator[f][0] = f;
        }
        for (int c = 1; c < arrayB.length + 1; c++) {
            mapComparator[0][c] = c;
        }
        for (int f = 1; f < arrayA.length + 1; f++) {
            for (int c = 1; c < arrayB.length + 1; c++) {
                upValue = mapComparator[f - 1][c] + 1;
                leftValue = mapComparator[f][c - 1] + 1;
                compareValue = arrayA[f - 1] == arrayB[c - 1] ? mapComparator[f - 1][c - 1] : mapComparator[f - 1][c - 1] + 1;
                mapComparator[f][c] = Math.min(Math.min(upValue, leftValue), compareValue);
            }
        }
        return mapComparator[arrayA.length][arrayB.length];
    }
}