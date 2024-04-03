package Test3.Greedy;

import java.util.*;

public class GreedyMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberFood = scanner.nextInt();
        int timeMax = scanner.nextInt();

        List<Integer> meals = new ArrayList<>();
        for (int i = 0; i < numberFood; i++) {
            meals.add(scanner.nextInt());
        }

        greedyChoice(timeMax, meals);
    }

    /**
     * Finds the maximum number of meals that can be eaten within a given time limit using a greedy approach.
     *
     * @param timeMax the maximum time limit for eating meals
     * @param meals   the list of meal times
     */
    public static void greedyChoice(int timeMax, List<Integer> meals){
        Collections.sort(meals); // Ordenar

        int count = 0;
        for (int time : meals) {
            if (time <= timeMax) {
                count++;
                timeMax -= time;
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}
