package AudiesParty.DataStructure;

import AudiesParty.Model.Edge;
import AudiesParty.Model.Group;
import AudiesParty.Model.Nodo;
import java.util.*;

public class GreedySpanningTree {

    public static List<Edge> maxSpanningTree(Graph graph, int x, int initIndex) {
        List<Edge> maxSpanningTree = new ArrayList<>();
        Set<Nodo> visited = new HashSet<>();
        Nodo startNode = graph.getNodos().get(initIndex);
        visited.add(startNode);
        PriorityQueue<Edge> queueEdges = new PriorityQueue<>((a, b) -> b.getWeightFriendly() - a.getWeightFriendly());
        queueEdges.addAll(startNode.getEdges());
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
        int index = result.size() - 1;
        int nodesAvailable = invites.getNodos().size();
        Edge currentEdge;
        Group group = new Group();
        boolean validProportion = (nodesAvailable >= missingGroups);
        while(( nodesAvailable >= missingGroups && missingGroups != 0) && validProportion){
            currentEdge = result.get(index);
            Nodo nodeA = currentEdge.getNodoA();
            Nodo nodeB = currentEdge.getNodoB();
            if(!visited.contains(nodeA) && nodesAvailable >= missingGroups){
                group.add(nodeA);
                visited.add(nodeA);
                nodesAvailable--;
            }
            if(!visited.contains(nodeB) && nodesAvailable >= missingGroups){
                group.add(nodeB);
                visited.add(nodeB);
                nodesAvailable--;
            }
            if(group.contains(nodeA) && group.contains(nodeB)){
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
