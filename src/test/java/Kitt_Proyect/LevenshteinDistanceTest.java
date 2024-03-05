package Kitt_Proyect;
import org.example.Kitt.Algoritmos.LevenshteinDistance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class LevenshteinDistanceTest {
    @Test
    void testLevenshteinDistance() {

        assertEquals(0, LevenshteinDistance.levenshteinDistance("apple", "apple"));

        assertEquals(3, LevenshteinDistance.levenshteinDistance("kitten", "sitting"));

        assertEquals(1, LevenshteinDistance.levenshteinDistance("kitten", "mitten"));

        assertEquals(5, LevenshteinDistance.levenshteinDistance(" ", "apple"));

        assertThrows(IllegalArgumentException.class, () -> {
            LevenshteinDistance.levenshteinDistance(null, "apple");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            LevenshteinDistance.levenshteinDistance("apple", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            LevenshteinDistance.levenshteinDistance(null, null);
        });
    }
}