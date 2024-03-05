package Kitt_Proyect;

import org.example.Kitt.Algoritmos.CompareText;
import org.example.Kitt.Model.ResultModel;
import org.example.Kitt.Utils.FileReader;
import org.junit.Test;

public class TextComparedTest {
    @Test
    public void mainTest (){
        String pathExample1A = "src/main/java/org/example/Kitt/file/file.txt";
        String pathExample1B = "src/main/java/org/example/Kitt/file/file2.txt";

        ResultModel resul1 = CompareText.compareText(pathExample1A, pathExample1B);
        FileReader.printComparison(resul1);

        String pathExample2A = "src/main/java/org/example/Kitt/file/file3.txt";
        String pathExample2B = "src/main/java/org/example/Kitt/file/file4.txt";

        ResultModel resul2 = CompareText.compareText(pathExample2A, pathExample2B);
        FileReader.printComparison(resul2);

        String pathExample3A = "src/main/java/org/example/Kitt/file/file5.txt";
        String pathExample3B = "src/main/java/org/example/Kitt/file/file6.txt";

        ResultModel resul3 = CompareText.compareText(pathExample3A, pathExample3B);
        FileReader.printComparison(resul3);

        String pathExample4 = "src/main/java/org/example/Kitt/file/file7.txt";
        String pathExample4Text2 = "src/main/java/org/example/Kitt/file/file8.txt";

        ResultModel resul4 = CompareText.compareText(pathExample4, pathExample4Text2);
        FileReader.printComparison(resul4);

    }
}
