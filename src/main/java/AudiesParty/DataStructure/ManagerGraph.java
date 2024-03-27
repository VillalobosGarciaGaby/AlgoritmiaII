package AudiesParty.DataStructure;

import AudiesParty.Model.Edge;
import AudiesParty.Model.Nodo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManagerGraph {
    /**
     * Creates a graph based on the given text.
     *
     * @param text The text containing node and edge information.
     * @return The created graph.
     */
    public static Graph createGraphPeople(String text){
        Graph graph = new Graph();
        String nameA, nameB;
        int weight;
        String[] lines = text.split("\n");
        String[] currentLine;
        for(String line : lines){
            currentLine = line.split(" ");
            if(currentLine.length == 1 ){
                graph.addNode(new Nodo(line));
            }else {
                nameA = currentLine[0];
                nameB = currentLine[1];
                weight = Integer.parseInt(currentLine[2]);
                graph.addEdge(nameA, nameB, weight);
            }
        }
        return graph;
    }

    /**
     * Creates a graph based on the given list of edges.
     *
     * @param edgeList The list of edges.
     * @return The created graph.
     */
    public static Graph createGraphByEdgeList(List<Edge> edgeList){
        Graph graph = new Graph();
        Set<Nodo> nodos = getEdgeList(edgeList);
        for(Nodo nodo : nodos){
            graph.addNode(nodo);
        }
        for(Edge edge: edgeList){
            graph.addEdge(edge.getNodoA().getNamePeople(), edge.getNodoB().getNamePeople(), edge.getWeightFriendly());
        }
        return graph;
    }

    /**
     * Extracts nodes from the given list of edges.
     *
     * @param edgeList The list of edges.
     * @return The set of nodes extracted from the edge list.
     */
    public static Set<Nodo> getEdgeList(List<Edge> edgeList){
        Set<Nodo> nodos = new HashSet<>();
        for(Edge edge: edgeList){
            nodos.add(edge.getNodoA());
            nodos.add(edge.getNodoB());
        }
        return nodos;
    }

}
