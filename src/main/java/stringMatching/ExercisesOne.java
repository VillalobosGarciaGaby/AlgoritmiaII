package stringMatching;

public class ExercisesOne {
    public static void main(String[] args) {
        String text = "000010001010001";
        String pattern = "0001";
        naiveStringMatch(text, pattern);
    }

    public static void naiveStringMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }
}