package Kitt_Proyect;
import org.example.Kitt.Algoritmos.LCS;
import org.example.Kitt.Model.ComparedTextModel;
import org.example.Kitt.Model.TupleModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class LCSTest {
    @Test
    public void testLCS() {
        String[] stringA = {"cat", "dog", "bird", "fish"};
        String[] stringB = {"dog", "fich", "horse"};
        List<TupleModel> badWords = new ArrayList<>();

        int result = LCS.LCS(stringA, stringB, badWords);

        assertEquals(2, result);
        assertEquals(1, badWords.size());
        assertEquals("fish", badWords.get(0).wordA);
        assertEquals("fich", badWords.get(0).wordB);
    }

    @Test
    public void testCompareWord() {
        ComparedTextModel model1 = LCS.compareWord("apple", "aple");
        ComparedTextModel model2 = LCS.compareWord("banana", "banana");

        assertEquals(80.0, model1.percentageEquals, 0.01);
        assertEquals(1, model1.distance);
        assertEquals("apple", model1.wordA);
        assertEquals("aple", model1.wordB);

        assertEquals(100.0, model2.percentageEquals, 0.01);
        assertEquals(0, model2.distance);
        assertEquals("banana", model2.wordA);
        assertEquals("banana", model2.wordB);
    }
}