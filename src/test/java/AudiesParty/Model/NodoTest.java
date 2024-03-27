package AudiesParty.Model;

import AudiesParty.Model.Nodo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodoTest {

    @Test
    void constructor_InitializesNameAndEdges() {
        Nodo nodo = new Nodo("Alice");

        assertEquals("Alice", nodo.getNamePeople());
        assertNotNull(nodo.getEdges());
        assertTrue(nodo.getEdges().isEmpty());
        assertFalse(nodo.isInAGroup());
    }

    @Test
    void equals_ReturnsTrueWhenObjectsAreEqual() {
        Nodo nodo1 = new Nodo("Alice");
        Nodo nodo2 = new Nodo("Alice");
        nodo1.setInAGroup(true);
        nodo2.setInAGroup(true);

        assertTrue(nodo1.equals(nodo2));
    }

    @Test
    void equals_ReturnsFalseWhenObjectsAreNotEqual() {
        Nodo nodo1 = new Nodo("Alice");
        Nodo nodo2 = new Nodo("Bob");

        assertFalse(nodo1.equals(nodo2));
    }

    @Test
    void hashCode_ReturnsSameValueForEqualObjects() {
        Nodo nodo1 = new Nodo("Alice");
        Nodo nodo2 = new Nodo("Alice");
        nodo1.setInAGroup(true);
        nodo2.setInAGroup(true);

        assertEquals(nodo1.hashCode(), nodo2.hashCode());
    }

    @Test
    void hashCode_ReturnsDifferentValueForDifferentObjects() {
        Nodo nodo1 = new Nodo("Alice");
        Nodo nodo2 = new Nodo("Bob");

        assertNotEquals(nodo1.hashCode(), nodo2.hashCode());
    }
}
