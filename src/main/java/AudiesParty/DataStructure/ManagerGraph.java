package org.example.AudiesParty.DataStructure;

import org.example.AudiesParty.Model.Edge;
import org.example.AudiesParty.Model.Nodo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class ManagerGraph {
    public static Graph createGraphPeopleByString(String text){
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

    public static Graph createGraphByEdgeList(List<Edge> edgeList){
        Graph graph = new Graph();
        Set<Nodo> nodos = getNodeListByEdgeList(edgeList);

        for(Nodo nodo : nodos){
            graph.addNode(nodo);
        }
        for(Edge edge: edgeList){
            graph.addEdge(edge.getNodoA().getNamePeople(), edge.getNodoB().getNamePeople(), edge.getWeightFriendly());
        }
        return graph;
    }

    /**
     * Return a sorted list
     * @param edgeList
     * @return
     */
    public static Set<Nodo> getNodeListByEdgeList(List<Edge> edgeList){
        Set<Nodo> nodos = new HashSet<>();
        for(Edge edge: edgeList){
            nodos.add(edge.getNodoA());
            nodos.add(edge.getNodoB());
        }
        return nodos;
    }

}
