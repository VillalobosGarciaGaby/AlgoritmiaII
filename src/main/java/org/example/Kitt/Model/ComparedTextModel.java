package org.example.Kitt.Model;

/**
 * Clase que representa un modelo para almacenar información sobre la comparación entre dos textos.
 */
public class ComparedTextModel {

    /**
     * Porcentaje de similitud entre los dos textos comparados.
     */
    public double percentageEquals;

    /**
     * Distancia entre los textos, que puede ser la distancia de Levenshtein u otra métrica de distancia utilizada en la comparación.
     */
    public int distance;

    /**
     * Una palabra del primer texto.
     */
    public String wordA;

    /**
     * Una palabra del segundo texto.
     */
    public String wordB;

    /**
     * Constructor de la clase ComparedTextModel.
     *
     * @param percentageEquals Porcentaje de similitud entre los dos textos comparados.
     * @param distance         Distancia entre los textos.
     * @param wordA            Una palabra del primer texto.
     * @param wordB            Una palabra del segundo texto.
     */
    public ComparedTextModel(double percentageEquals, int distance, String wordA, String wordB) {
        this.percentageEquals = percentageEquals;
        this.distance = distance;
        this.wordA = wordA;
        this.wordB = wordB;
    }
}
