package Test3;

import Test3.Greedy.GreedyMain;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GreedyMainTest {
    @Test
    public void testGreedyChoice1() {
        int timeMax = 10;
        List<Integer> meals = Arrays.asList(2, 4, 6, 8);
        int expectedCount = 2;

        GreedyMain.greedyChoice(timeMax, meals);

    }

    @Test
    public void testGreedyChoice2() {
        int timeMax = 5;
        List<Integer> meals = Arrays.asList(1, 3, 5, 7, 9);
        int expectedCount = 2;

        GreedyMain.greedyChoice(timeMax, meals);

    }

    @Test
    public void testGreedyChoice3() {
        int timeMax = 15;
        List<Integer> meals = Arrays.asList(10, 20, 30, 40, 50);
        int expectedCount = 1;

        GreedyMain.greedyChoice(timeMax, meals);

    }
}
