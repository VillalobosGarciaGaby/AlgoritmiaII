package AudiesParty.DataStructure;

import AudiesParty.DataStructure.Graph;
import AudiesParty.Model.Nodo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

    @Test
    void addNode_AddsNodeSuccessfully() {
        Graph graph = new Graph();
        Nodo node = new Nodo("Alice");
        graph.addNode(node);

        assertTrue(graph.getNodos().contains(node));
    }

    @Test
    void addEdge_AddsEdgeSuccessfully() {
        Graph graph = new Graph();
        Nodo nodeA = new Nodo("Alice");
        Nodo nodeB = new Nodo("Bob");
        graph.addNode(nodeA);
        graph.addNode(nodeB);

        graph.addEdge("Alice", "Bob", 10);

        assertEquals(1, graph.getEdges().size());
    }

    @Test
    void getNodeByName_ReturnsCorrectNode() {
        Graph graph = new Graph();
        Nodo nodeA = new Nodo("Alice");
        Nodo nodeB = new Nodo("Bob");
        graph.addNode(nodeA);
        graph.addNode(nodeB);

        Nodo result = graph.getNodeByName("Bob");

        assertEquals(nodeB, result);
    }
}