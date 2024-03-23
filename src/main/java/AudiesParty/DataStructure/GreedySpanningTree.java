package org.example.AudiesParty.DataStructure;

import org.example.AudiesParty.Model.Edge;
import org.example.AudiesParty.Model.Group;
import org.example.AudiesParty.Model.Nodo;
import java.util.*;


public class GreedySpanningTree {

    public static List<Edge> maxSpanningTree(Graph graph, int x, int initIndex) {
        List<Edge> maxSpanningTree = new ArrayList<>();
        Set<Nodo> visited = new HashSet<>();
        Nodo startNodo = graph.getNodos().get(initIndex);
        visited.add(startNodo);
        PriorityQueue<Edge> queueEdges = new PriorityQueue<>((a, b) -> b.getWeightFriendly() - a.getWeightFriendly());
        queueEdges.addAll(startNodo.getEdges());
        while (!queueEdges.isEmpty()) {
            Edge edge = queueEdges.poll();
            Nodo current;
            if (edge.weightFriendly < x) {
                continue;
            }
            if (!visited.contains(edge.getNodoA())) {
                current = edge.getNodoA();
            } else if (!visited.contains(edge.getNodoB())) {
                current = edge.getNodoB();
            } else {
                continue;
            }
            visited.add(current);
            maxSpanningTree.add(edge);
            for (Edge nextEdge : current.getEdges()) {
                if (!visited.contains(nextEdge.getOtherNode(current))) {
                    queueEdges.add(nextEdge);
                }
            }
        }

        return maxSpanningTree;
    }


    public static List<Group> getBestGroups(Graph invites, int missingGroups) {
        List<Group> groups = new ArrayList<>();
        Set<Nodo> visited = new HashSet<>();
        List<Edge> result = maxSpanningTree(invites, 0, 0);
        Collections.sort(result);
        int index = result.size()-1;
        int nodesAvailable = invites.getNodos().size();
        Edge currentEdge;
        Group group = new Group();
        boolean validProportion = (nodesAvailable >= missingGroups);
        while(( nodesAvailable >= missingGroups && missingGroups > 0) && validProportion){
            currentEdge = result.get(index);
            Nodo nodoA = currentEdge.getNodoA();
            Nodo nodoB = currentEdge.getNodoB();
            if(!visited.contains(nodoA) && nodesAvailable >= missingGroups){
                group.add(nodoA);
                visited.add(nodoA);
                nodesAvailable--;
            }
            if(!visited.contains(nodoB) && nodesAvailable >= missingGroups){
                group.add(nodoB);
                visited.add(nodoB);
                nodesAvailable--;
            }
            if(group.contains(nodoA) && group.contains(nodoB)){
                group.addEdge(currentEdge);
            }
            if((index - 1 >= 0 && !isConnected(currentEdge, result.get(index - 1)) )|| nodesAvailable < missingGroups){
                groups.add(group);
                missingGroups--;
                group = new Group();
            }
            index--;

            if(index == -1 && visited.size() < invites.getNodos().size()){
                index = result.size()-1;
            }
        }
        return groups;
    }

    private static boolean isConnected(Edge edgeA, Edge edgeB){
        boolean result = false;
        if(edgeA.getNodoA().equals(edgeB.getNodoA())){
            result = true;
        }else if(edgeA.getNodoA().equals(edgeB.getNodoB())){
            result = true;
        }else if(edgeA.getNodoB().equals(edgeB.getNodoA())){
            result = true;
        }else if(edgeA.getNodoB().equals(edgeB.getNodoB())){
            result = true;
        }
        return result;
    }

}
