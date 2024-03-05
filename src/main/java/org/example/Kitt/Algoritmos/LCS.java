package org.example.Kitt.Algoritmos;

import org.example.Kitt.Model.TupleModel;
import org.example.Kitt.Model.ComparedTextModel;

import java.util.List;

/**
 * Clase que implementa el algoritmo de Subsecuencia Común Más Larga (LCS).
 */
public class LCS {

    /**
     * Porcentaje mínimo de similitud para considerar dos palabras como coincidentes.
     */
    public static final int MINIMUM_PERCENTAGE = 55;

    /**
     * Calcula la longitud de la subsecuencia común más larga entre dos cadenas de palabras.
     *
     * @param string_A         Arreglo de palabras de la primera cadena.
     * @param string_B         Arreglo de palabras de la segunda cadena.
     * @param badWordStorage  Lista donde se almacenan las palabras no coincidentes.
     * @return La longitud de la subsecuencia común más larga.
     */
    public static int LCS(String[] string_A, String[] string_B, List<TupleModel> badWordStorage){

        if (string_A == null || string_B == null || string_A.length == 0 || string_B.length == 0) return 0;

        int[][] mapComparator = new int[string_A.length + 1][string_B.length + 1];
        for(int row = 1; row <= string_A.length; row++){
            for(int column = 1; column <= string_B.length; column++){
                if(string_A[row -1].equals(string_B[column -1])){
                    mapComparator[row][column] = mapComparator[row -1][column -1] + 1;
                    // levelshtein -> en eso de que no son iguales, calcular el % de similitud.
                    // compara de que sea mayor a 3 y evitando articulos.
                }else if ((string_A[row -1].length() > 2 && string_B[column -1].length() > 2) && compareWord(string_A[row -1], string_B[column -1]).percentageEquals > MINIMUM_PERCENTAGE) {
                    mapComparator[row][column] = mapComparator[row -1][column -1] + 1;
                    badWordStorage.add(new TupleModel(string_A[row -1], string_B[column -1]));
                } else {
                    mapComparator[row][column] = Math.max(mapComparator[row -1][column], mapComparator[row][column -1]);
                }
            }
        }
        return mapComparator[string_A.length][string_B.length];
    }

    // retornar el porcentaje.
    public static ComparedTextModel compareWord(String wordA, String wordB){

        int similitude = LevenshteinDistance.levenshteinDistance(wordA, wordB);
        int maxSizeWord = Math.max(wordA.length(), wordB.length());
        double percentage = (1 - ((double) similitude / maxSizeWord))*100;

        return new ComparedTextModel(percentage, similitude, wordA, wordB);
    }
}
