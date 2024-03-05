package org.example.Kitt.Algoritmos;

import org.example.Kitt.Model.ResultModel;
import org.example.Kitt.Model.TupleModel;
import org.example.Kitt.Utils.FileReader;
import java.util.ArrayList;

public class CompareText {

    /**
     * Tenemos una cadena de strings, dividiendo por oraciones, compara cada oracion del primer texto
     * con cada oracion del segundo texto, con LCS. Se incrementa el arreglo de resultados y porcentaje de palabras
     * Tenemos un model que contiene porcentaje, una lista que tienes todos los elementos y otro de palabras coincidentes.
     *
     * @param path_A Text 1
     * @param path_B Text 2
     * @return el porcentaje, una lista de todas las palabras, y palabras coincidentes.
     */
    public static ResultModel compareText(String path_A, String path_B) {
        ArrayList<TupleModel> badWords = new ArrayList<>();
        String[] sentencesA = FileReader.readTxt(path_A).split("\\.");
        String[] sentencesB = FileReader.readTxt(path_B).split("\\.");

        String[] lowerWordsA;
        String[] lowerWordsB;
        int[] results = new int[sentencesB.length];
        int totalWordB = 0;

        for(int f = 0; f < sentencesA.length; f++){
            for (int c = 0; c < sentencesB.length; c++) {
                lowerWordsA = getLowerCaseList(sentencesA[f].split(" "));
                lowerWordsB = getLowerCaseList(sentencesB[c].split(" "));
                if( f == 0) totalWordB += lowerWordsB.length;
                int currentLcs = LCS.LCS(lowerWordsA, lowerWordsB, badWords);
                results[c] = Math.max(currentLcs, results[c]);

            }
        }
        int totalValueArray = totalValueArray(results);
        double percentage = ((double) totalValueArray /totalWordB)*100;
        return new ResultModel(percentage, totalValueArray, badWords );
    }

    /**
     * Es la suma de todos los elementos de ese arreglo.
     * @param values son los elementos
     * @return el resultado de la suma
     */
    private static int totalValueArray(int[] values){
        int result = 0;
        for(int current: values) result += current;
        return result;
    }

    /**
     * Devuelve toda la cadena en minuscula, elimina una cadena vacia y agrega los elementos originales
     * @param list lista de cadenas minusculas
     * @return toda la lista
     */
    private static String[] getLowerCaseList(String[] list) {
        ArrayList<String> listFiltered = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if(list[i].isEmpty()) continue;
            listFiltered.add(list[i].toLowerCase());
        }
        return listFiltered.toArray(new String[0]);
    }

}