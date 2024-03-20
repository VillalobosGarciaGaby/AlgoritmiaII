package DFA;

public class DFA {
    private static final int NO_OF_CHARS = 256;

    private static int[][] buildTransitionTable(String pattern, int patternLength) {
        int[][] transitionTable = new int[patternLength + 1][NO_OF_CHARS];

        for (int currentState = 0; currentState <= patternLength; currentState++) {
            for (int character = 0; character < NO_OF_CHARS; character++) {
                transitionTable[currentState][character] = getNextState(pattern, patternLength, currentState, character);
            }
        }

        return transitionTable;
    }

    private static int getNextState(String pattern, int patternLength, int currentState, int character) {
        if (currentState < patternLength && character == pattern.charAt(currentState)) {
            return currentState + 1;
        }

        for (int nextState = currentState; nextState > 0; nextState--) {
            if (pattern.charAt(nextState - 1) == character) {
                int matchingIndex = 0;
                for (matchingIndex = 0; matchingIndex < nextState - 1; matchingIndex++) {
                    if (pattern.charAt(matchingIndex) != pattern.charAt(currentState - nextState + 1 + matchingIndex)) {
                        break;
                    }
                }
                if (matchingIndex == nextState - 1) {
                    return nextState;
                }
            }
        }
        return 0;
    }

    public static void searchPattern(String text, String pattern) {
        int patternLength = pattern.length();
        int textLength = text.length();
        int[][] transitionTable = buildTransitionTable(pattern, patternLength);

        int currentState = 0;

        for (int currentIndex = 0; currentIndex < textLength; currentIndex++) {
            currentState = transitionTable[currentState][text.charAt(currentIndex)];
            if (currentState == patternLength) {
                int patternIndex = (currentIndex - patternLength + 1);
                System.out.println("Pattern found at index " + patternIndex);
            }
        }
    }

    public static void main(String[] args) {
        String text = "THIS IS A TEST TEXT";
        String pattern = "TEST";
        searchPattern(text, pattern);
        String text1 = "AABAACAADAABAABA";
        String pattern1 = "AABA";
        searchPattern(text1, pattern1);

    }
}