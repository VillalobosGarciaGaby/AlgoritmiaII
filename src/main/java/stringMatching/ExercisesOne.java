package stringMatching;

public class ExercisesOne {
    public static void main(String[] args) {
        String text = "000010001010001";
        String pattern = "0001";
        naiveStringMatch(text, pattern);
    }

    public static void naiveStringMatch(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;
            for (j = 0; j < patternLength; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == patternLength) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }
}