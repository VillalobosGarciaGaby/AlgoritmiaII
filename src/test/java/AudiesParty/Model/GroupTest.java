package AudiesParty.Model;

import AudiesParty.Model.Edge;
import AudiesParty.Model.Group;
import AudiesParty.Model.Nodo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GroupTest {

    @Test
    void constructor_InitializesEmptyGroup() {
        Group group = new Group();
        assertTrue(group.getNodos().isEmpty());
        assertTrue(group.getEdges().isEmpty());
        assertEquals(0, group.getBestGroup());
        assertEquals(0, group.getLeastGroup());
    }

    @Test
    void add_AddsNodeToGroup() {
        Group group = new Group();
        Nodo nodo = new Nodo("Alice");
        group.add(nodo);
        assertTrue(group.contains(nodo));
    }

    @Test
    void addEdge_AddsEdgeToGroupAndUpdateBestAndLeastGroup() {
        Group group = new Group();
        Nodo nodoA = new Nodo("Alice");
        Nodo nodoB = new Nodo("Bob");
        Edge edge1 = new Edge(nodoA, nodoB, 10);
        Edge edge2 = new Edge(nodoA, nodoB, 5);

        group.addEdge(edge1);
        assertEquals(10, group.getBestGroup());
        assertEquals(10, group.getLeastGroup());
        assertEquals(1, group.getEdges().size());

        group.addEdge(edge2);
        assertEquals(10, group.getBestGroup());
        assertEquals(5, group.getLeastGroup());
        assertEquals(2, group.getEdges().size());
    }

    @Test
    void contains_ReturnsTrueForExistingNode() {
        Group group = new Group();
        Nodo nodo = new Nodo("Alice");
        group.add(nodo);
        assertTrue(group.contains(nodo));
    }

    @Test
    void contains_ReturnsFalseForNonExistingNode() {
        Group group = new Group();
        Nodo nodo = new Nodo("Alice");
        assertFalse(group.contains(nodo));
    }
}

