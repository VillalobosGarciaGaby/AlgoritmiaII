package AudiesParty.DataStructure;

import AudiesParty.Model.Edge;
import AudiesParty.Model.Group;
import AudiesParty.Model.Nodo;
import AudiesParty.Utils.TextReader;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CalculatorAudieParty {

    /**
     * Calculates the best group of guests to invite to Audie's party.
     *
     * @param pathInviteList    The path to the file containing the list of guests and their connections.
     * @param friendLevelMinimun The minimum level of friendship required to include a connection in the best group.
     * @return The list of edges representing the best group of guests.
     */
    public List<Edge> calculateBestGroup(String pathInviteList, int friendLevelMinimun) {
        String inviteList = TextReader.readTxt(pathInviteList);
        Graph graph = ManagerGraph.createGraphPeople(inviteList);
        List<Edge> bestList = null;
        List<Edge> currentList;
        for (int i = 0; i < graph.getNodos().size(); i++) {
            currentList = GreedySpanningTree.maxSpanningTree(graph, friendLevelMinimun, i);
            if ((i == 0) || (currentList.size() > bestList.size() && getWeightEdgeList(currentList) > getWeightEdgeList(bestList))) {
                bestList = currentList;
            }
        }
        return bestList;
    }

    /**
     * Generates a string representing the list of guests based on a list of edges.
     *
     * @param edgeList The list of edges representing the connections between guests.
     * @return A string representing the list of guests.
     */
    private String getEdgeList(List<Edge> edgeList) {
        Set<String> names = new TreeSet<>();
        for (Edge currentEdge : edgeList) {
            names.add(currentEdge.nodoA.getNamePeople());
            names.add(currentEdge.nodoB.getNamePeople());
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String current : names) {
            stringBuilder.append(current).append(" ");
        }
        return stringBuilder.toString();
    }

    /**
     * Generates a string representing the list of groups of guests.
     *
     * @param groups The list of groups of guests.
     * @return A string representing the list of groups of guests.
     */
    private String getGroups(List<Group> groups) {
        StringBuilder stringBuilder = new StringBuilder();
        if (groups.isEmpty()) {
            return "It is not possible";
        }
        for (Group currentGroup : groups) {
            StringBuilder groupString = new StringBuilder();
            for (Nodo nodo : currentGroup.getNodos()) {
                groupString.append(nodo.getNamePeople()).append(" ");
            }
            stringBuilder.append(groupString.toString().trim()).append("\n");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    /**
     * Calculates the total weight of a list of edges.
     *
     * @param edgeList The list of edges.
     * @return The total weight of the edges.
     */
    private int getWeightEdgeList(List<Edge> edgeList) {
        int totalWeight = 0;
        for (Edge currentEdge : edgeList) {
            totalWeight += currentEdge.getWeightFriendly();
        }
        return totalWeight;
    }

    /**
     * Finds the group with the strongest or least friendly relationship among a list of groups.
     *
     * @param groups       The list of groups.
     * @param bestFriendly Indicates whether to find the group with the strongest (true) or least (false) friendly relationship.
     * @return A string representing the group with the strongest or least friendly relationship.
     */
    private String getGroupWithRelationship(List<Group> groups, boolean bestFriendly) {
        StringBuilder stringBuilder = new StringBuilder();
        Group selectedGroup = groups.get(0);
        for (Group group : groups) {
            if (group.getEdges().size() > 0) {
                if (selectedGroup == null ||
                        (bestFriendly && group.getBestGroup() > selectedGroup.getLeastGroup()) ||
                        (!bestFriendly && group.getLeastGroup() < selectedGroup.getBestGroup())) {
                    selectedGroup = group;
                }
            }
        }
        for (Nodo nodo : selectedGroup.getNodos()) {
            if (selectedGroup.getNodos().size() == 1) {
                stringBuilder.append("None");
                continue;
            }
            stringBuilder.append(nodo.getNamePeople()).append(" ");
        }

        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    /**
     * Finds the group with the strongest friendly relationship among a list of groups.
     *
     * @param groups The list of groups.
     * @return A string representing the group with the strongest friendly relationship.
     */
    private String getGroupWithBestFriendly(List<Group> groups) {
        return getGroupWithRelationship(groups, true);
    }

    /**
     * Finds the group with the least friendly relationship among a list of groups.
     *
     * @param groups The list of groups.
     * @return A string representing the group with the least friendly relationship.
     */
    private String getGroupWithLeastFriendly(List<Group> groups) {
        return getGroupWithRelationship(groups, false);
    }

    /**
     * Generates the best plan for Audie's party based on the input parameters.
     *
     * @param pathInviteList    The path to the file containing the list of guests and their connections.
     * @param friendLevelMinimun The minimum level of friendship required to include a connection in the best group.
     * @param quantityGroups    The number of groups to form for the party.
     * @return A string representing the best plan for Audie's party.
     */
    public String generateBestPartyPlan(String pathInviteList, int friendLevelMinimun, int quantityGroups) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Edge> listEdges = calculateBestGroup(pathInviteList, friendLevelMinimun);
        stringBuilder.append("Guests:\n");
        stringBuilder.append(getEdgeList(listEdges) + "\n");
        Graph invites = ManagerGraph.createGraphByEdgeList(listEdges);
        List<Group> groups = GreedySpanningTree.getBestGroups(invites, quantityGroups);
        stringBuilder.append("Group:\n");
        stringBuilder.append(groups.size()).append("\n");
        stringBuilder.append(getGroups(groups));
        if (!groups.isEmpty()) {
            String groupWithBestFriendly = getGroupWithBestFriendly(groups);
            String groupWithLeastFriendly = getGroupWithLeastFriendly(groups);
            stringBuilder.append("Group with strongest friendly relationship: " + groupWithBestFriendly);
            stringBuilder.append("Group with least friendly relationship: " + groupWithLeastFriendly);
        }
        stringBuilder.append("--------------------------------------------------\n");
        return stringBuilder.toString();
    }
}
