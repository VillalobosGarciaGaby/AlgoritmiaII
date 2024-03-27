package AudiesParty.DataStructure;

import lombok.Getter;
import lombok.Setter;
import AudiesParty.Model.Edge;
import AudiesParty.Model.Nodo;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Graph {
    private List<Nodo> nodos;
    private List<Edge> edges;

    public Graph(){
        nodos = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addNode(Nodo nodo){
        nodo.setEdges(new ArrayList<>());
        nodos.add(nodo);
    }

    public void addEdge(String nameA, String nameB, int weight){
        Nodo nodoA = getNodeByName(nameA);
        Nodo nodoB = getNodeByName(nameB);
        Edge edge = new Edge(nodoA, nodoB, weight);
        edges.add(edge);
        nodoA.getEdges().add(edge);
        nodoB.getEdges().add(edge);
    }

    public Nodo getNodeByName(String nodeName){
        Nodo nodoFound = null;
        for (Nodo currentNodo : nodos) {
            if (currentNodo.getNamePeople().equals(nodeName)) {
                nodoFound = currentNodo;
                break;
            }
        }
        return nodoFound;

    }

}
