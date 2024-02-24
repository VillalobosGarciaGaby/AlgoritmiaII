package PracticaF;

import org.example.PracticeF;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class PracticaFTest {

    @Test
    public void test1() throws IOException {
        String input = """
                2
                4
                10
                20
                30
                40
                5
                5
                4
                3
                2
                1
                """;
        String expectedOutput = "4\n5\n";

        assertEquals(expectedOutput.trim(), runTest(input).trim());
    }

    @Test
    public void test2() throws IOException {
        String input = """
                1
                3
                1
                2
                3
                """;
        String expectedOutput = "3";

        assertEquals(expectedOutput.trim(), runTest(input).trim());
    }

    @Test
    public void test3() throws IOException {
        String input = """
                1
                6
                10
                20
                30
                40
                50
                60
                """;
        String expectedOutput = "6\n";

        assertEquals(expectedOutput.trim(), runTest(input).trim());
    }

    private String runTest(String input) throws IOException {
        java.io.ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        java.io.ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new java.io.PrintStream(out));
        PracticeF.main(null);
        return out.toString();
    }

}