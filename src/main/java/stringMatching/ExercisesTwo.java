package stringMatching;

public class ExercisesTwo {

    public static void rabinKarpMatcher(char[] text, char[] pattern, int alphabetSize, int primeNumber) {
        int textSize = text.length;
        int patternSize = pattern.length;
        int h = 1;

        for (int i = 0; i < patternSize - 1; i++) {
            h = (h * alphabetSize) % primeNumber;
        }

        int patternHash = 0;
        int textHash = 0;
        for (int i = 0; i < patternSize; i++) {
            patternHash = (alphabetSize * patternHash + pattern[i]) % primeNumber;
            textHash = (alphabetSize * textHash + text[i]) % primeNumber;
        }

        for (int s = 0; s <= textSize - patternSize; s++) {

            if (patternHash == textHash) {
                int i;
                for (i = 0; i < patternSize; i++) {
                    if (text[s + i] != pattern[i])
                        break;
                }
                if (i == patternSize) {
                    System.out.println("Pattern found at index " + s);
                }
            }

            if (s < textSize - patternSize) {
                textHash = (alphabetSize * (textHash - text[s] * h) + text[s + patternSize]) % primeNumber;
                if (textHash < 0)
                    textHash = (textHash + primeNumber);
            }
        }
    }

    public static void main(String[] args) {
        char[] txt = "THIS IS A TEST TEXT".toCharArray();
        char[] pat = "TEST".toCharArray();
        char[] txt1 = "AABAACAADAABAABA".toCharArray();
        char[] pat1 = "AABA".toCharArray();
        int alphabetSize = 256; // El tamaño del alfabeto Unicode, que es 256, abarca un mayor rango de caracteres.
        int primeNumber = 101; // Un número primo que se utiliza para calcular los valores hash y para reducir la posibilidad de colisiones de hash.

        // Perform pattern matching
        System.out.println("Occurrences of pattern pat[] in txt[]:");
        rabinKarpMatcher(txt, pat, alphabetSize, primeNumber);
        System.out.println("\nOccurrences of pattern pat1[] in txt1[]:");
        rabinKarpMatcher(txt1, pat1, alphabetSize, primeNumber);
    }
}
