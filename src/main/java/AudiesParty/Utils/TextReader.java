package AudiesParty.Utils;

import java.io.*;
public class TextReader {
    public static String readTxt(String path) {
        String textFromFile = "";
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = buffer.readLine()) != null) {
                content.append(line + "\n");
            }
            textFromFile = content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textFromFile;
    }
}
