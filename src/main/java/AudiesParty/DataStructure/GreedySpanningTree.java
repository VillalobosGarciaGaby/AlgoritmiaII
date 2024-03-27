package AudiesParty.DataStructure;

import AudiesParty.Model.Edge;
import AudiesParty.Model.Group;
import AudiesParty.Model.Nodo;
import java.util.*;

public class GreedySpanningTree {

    /**
     * Calculates the Maximum Spanning Tree (MST) of a given graph using the Prim's algorithm.
     * An MST is a subgraph of a connected, undirected graph, which contains all the vertices of the original graph,
     * where the sum of edge weights is minimum.
     *
     * @param graph     The given graph.
     * @param x         The minimum weight value to consider for adding an edge to the MST.
     * @param initIndex The index of the initial node from which MST construction starts.
     * @return A list of edges forming the MST.
     */
    public static List<Edge> maxSpanningTree(Graph graph, int x, int initIndex) {
        List<Edge> maxSpanningTree = new ArrayList<>();
        Set<Nodo> visited = new HashSet<>();
        PriorityQueue<Edge> queueEdges = new PriorityQueue<>((a, b) -> b.getWeightFriendly() - a.getWeightFriendly()); //donde la suma de los pesos de las aristas es mínima.
        visitNode(graph, initIndex, visited, queueEdges);
        while (!queueEdges.isEmpty()) {
            Edge edge = queueEdges.poll();
            if (edge.getWeightFriendly() < x) {
                continue;
            }
            Nodo current = getUnvisitedNode(edge, visited);
            if (current != null) {
                visited.add(current);
                maxSpanningTree.add(edge);
                addAdjacentEdges(current, visited, queueEdges);
            }
        }

        return maxSpanningTree;
    }

    /**
     * Visits a given node in the graph and adds its edges to the priority queue.
     *
     * @param graph      The given graph.
     * @param index      The index of the node to visit.
     * @param visited    The set of visited nodes.
     * @param queueEdges The priority queue of edges.
     */
    private static void visitNode(Graph graph, int index, Set<Nodo> visited, PriorityQueue<Edge> queueEdges) {
        Nodo startNode = graph.getNodos().get(index);
        visited.add(startNode);
        queueEdges.addAll(startNode.getEdges());
    }

    /**
     * Gets the unvisited node of a given edge.
     *
     * @param edge    The given edge.
     * @param visited The set of visited nodes.
     * @return The unvisited node or null if both nodes of the edge are visited.
     */
    private static Nodo getUnvisitedNode(Edge edge, Set<Nodo> visited) {
        Nodo nodeA = edge.getNodoA();
        Nodo nodeB = edge.getNodoB();
        return visited.contains(nodeA) ? (visited.contains(nodeB) ? null : nodeB) : nodeA; // agregar nodo no visitado
    }

    /**
     * Adds adjacent edges of an unvisited node to the priority queue if they do not lead to visited nodes.
     *
     * @param current    The current node.
     * @param visited    The set of visited nodes.
     * @param queueEdges The priority queue of edges.
     */
    private static void addAdjacentEdges(Nodo current, Set<Nodo> visited, PriorityQueue<Edge> queueEdges) {
        for (Edge nextEdge : current.getEdges()) {
            if (!visited.contains(nextEdge.getOtherNode(current))) { //Agrega las aristas adyacentes de un nodo no visitado a la cola de prioridad
                queueEdges.add(nextEdge);
            }
        }
    }

    /**
     * Obtains the best groups from the given graph of invitations.
     * @param invites The graph representing invitations.
     * @param missingGroups The number of missing groups to form.
     * @return The list of best groups formed based on the given criteria.
     */
    public static List<Group> getBestGroups(Graph invites, int missingGroups) {
        List<Group> groups = new ArrayList<>();
        Set<Nodo> visited = new HashSet<>();
        // Se obtiene el árbol de expansión máxima
        List<Edge> result = maxSpanningTree(invites, 0, 0);
        // Se ordena la lista de aristas en orden ascendente
        Collections.sort(result);
        int index = result.size() - 1;
        int nodesAvailable = invites.getNodos().size();
        Edge currentEdge;
        Group group = new Group();
        // Verifica si la proporción de nodos disponibles es suficiente
        boolean validProportion = (nodesAvailable >= missingGroups);
        while(( nodesAvailable >= missingGroups && missingGroups != 0) && validProportion){ // hay nodos disponibles y el número de grupos no es cero
            currentEdge = result.get(index);
            Nodo nodeA = currentEdge.getNodoA();
            Nodo nodeB = currentEdge.getNodoB();
            // Si el nodo A no ha sido visitado
            if(!visited.contains(nodeA) && nodesAvailable >= missingGroups){
                group.add(nodeA);
                visited.add(nodeA);
                nodesAvailable--;
            }
            // Si el nodo B no ha sido visitado
            if(!visited.contains(nodeB) && nodesAvailable >= missingGroups){
                group.add(nodeB);
                visited.add(nodeB);
                nodesAvailable--;
            }
            // Si tanto el nodo A como el nodo B están en el grupo
            if(group.contains(nodeA) && group.contains(nodeB)){
                group.addEdge(currentEdge);
            }
            //no hay nodos disponibles y el indice es mayor o igual a cero
            if((index - 1 >= 0 && !isConnected(currentEdge, result.get(index - 1)) )|| nodesAvailable < missingGroups){
                groups.add(group);
                missingGroups--;
                group = new Group();
            }
            index--;

            // Si el índice es -1 y el número de nodos visitados es menor que el total de nodos
            if(index == -1 && visited.size() < invites.getNodos().size()){
                index = result.size()-1;
            }
        }
        return groups;
    }

    // Si dos aristas estan conectadas o no, ya sea por un nodo en comun.
    private static boolean isConnected(Edge edgeA, Edge edgeB) {
        return edgeA.getNodoA().equals(edgeB.getNodoA()) ||
                edgeA.getNodoA().equals(edgeB.getNodoB()) ||
                edgeA.getNodoB().equals(edgeB.getNodoA()) ||
                edgeA.getNodoB().equals(edgeB.getNodoB());
    }


}
