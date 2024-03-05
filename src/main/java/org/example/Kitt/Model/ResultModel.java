package org.example.Kitt.Model;

import java.util.ArrayList;

/**
 * Clase que representa un modelo para almacenar el resultado de la comparación entre dos textos.
 */
public class ResultModel {

    /**
     * Tamaño de la subcadena común más larga encontrada entre los dos textos.
     */
    public int sizeSubString;

    /**
     * Porcentaje de similitud entre los dos textos comparados.
     */
    public double percentage;

    /**
     * Lista de palabras que no coinciden entre los dos textos.
     */
    public ArrayList<TupleModel> badWords;

    /**
     * Constructor de la clase ResultModel.
     *
     * @param percentage Porcentaje de similitud entre los dos textos comparados.
     * @param badWords   Lista de palabras que no coinciden entre los dos textos.
     * @param lcs        Tamaño de la subcadena común más larga encontrada entre los dos textos.
     */
    public ResultModel(double percentage, int lcs, ArrayList<TupleModel> badWords) {
        this.percentage = percentage;
        this.badWords = badWords;
        this.sizeSubString = lcs;
    }
}
