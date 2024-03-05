package org.example.Kitt.Utils;

import org.example.Kitt.Model.ResultModel;
import org.example.Kitt.Model.TupleModel;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {
    public static String readTxt(String path) {
        String textFromFile = "";
        try (BufferedReader buffer = new BufferedReader(new java.io.FileReader(path))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = buffer.readLine()) != null) {
                content.append(line + " ");
            }
            textFromFile = content.toString().substring(0, content.toString().length() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textFromFile;
    }

    public static void printComparison(ResultModel resultComparison){
        System.out.println("---------------------------------------------------------");
        String formattedPercentage = String.format("%.2f%%", resultComparison.percentage);
        System.out.println("Similitude: " + formattedPercentage);
        System.out.println("Spelling errors");
        for(TupleModel current: resultComparison.badWords){
            System.out.println("- "+current.wordA+", "+current.wordB);
        }
        System.out.println("---------------------------------------------------------\n");
    }
}
