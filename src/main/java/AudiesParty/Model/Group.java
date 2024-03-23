package org.example.AudiesParty.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Group {
    private Set<Nodo> nodos;
    private List<Edge> edges;
    private int bestGroup;
    private int leastGroup;

    public Group(){
        nodos = new HashSet<>();
        edges = new ArrayList<>();
        bestGroup = 0;
        leastGroup = 0;
    }

    public void add(Nodo nodo){
        nodos.add(nodo);
    }

    public void addEdge(Edge edge){
        edges.add(edge);
        if(edges.size() == 1){
            leastGroup = edge.getWeightFriendly();
        }
        if(edge.getWeightFriendly() > bestGroup){
            bestGroup = edge.getWeightFriendly();
        }
        if(edge.getWeightFriendly() < leastGroup){
            leastGroup = edge.getWeightFriendly();
        }
    }

    public boolean contains(Nodo nodo){
        return nodos.contains(nodo);
    }
}
