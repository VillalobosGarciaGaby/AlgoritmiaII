package AudiesParty.DataStructure;

import org.example.AudiesParty.DataStructure.Graph;
import org.example.AudiesParty.DataStructure.GreedySpanningTree;
import org.example.AudiesParty.Model.Edge;
import org.example.AudiesParty.Model.Group;
import org.example.AudiesParty.Model.Nodo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class GreedySpanningTreeTest {

    @Test
    void maxSpanningTree_ReturnsEmptyListWhenGraphIsEmpty() {
        Graph emptyGraph = new Graph();
        List<Edge> result = GreedySpanningTree.maxSpanningTree(emptyGraph, 0, 0);
        assertTrue(result.isEmpty());
    }

    @Test
    void maxSpanningTree_ReturnsMaxSpanningTree() {
        Graph graph = new Graph();
        Nodo nodoA = new Nodo("A");
        Nodo nodoB = new Nodo("B");
        Nodo nodoC = new Nodo("C");
        Nodo nodoD = new Nodo("D");
        Edge edgeAB = new Edge(nodoA, nodoB, 10);
        Edge edgeAC = new Edge(nodoA, nodoC, 5);
        Edge edgeBC = new Edge(nodoB, nodoC, 15);
        Edge edgeBD = new Edge(nodoB, nodoD, 20);
        graph.addNode(nodoA);
        graph.addNode(nodoB);
        graph.addNode(nodoC);
        graph.addNode(nodoD);
        graph.addEdge("A", "B", 10);
        graph.addEdge("A", "C", 5);
        graph.addEdge("B", "C", 15);
        graph.addEdge("B", "D", 20);

        List<Edge> result = GreedySpanningTree.maxSpanningTree(graph, 8, 0);

        assertEquals(3, result.size());
    }

    @Test
    void getBestGroups_ReturnsEmptyListWhenGraphIsEmpty() {
        Graph emptyGraph = new Graph();
        List<Group> result = GreedySpanningTree.getBestGroups(emptyGraph, 1);
        assertTrue(result.isEmpty());
    }
}
