package AudiesParty.DataStructure;

import AudiesParty.Model.Edge;
import AudiesParty.Model.Group;
import AudiesParty.Model.Nodo;
import AudiesParty.Utils.TextReader;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CalculatorAudieParty {

    public List<Edge> calculateBestGroup(String pathInviteList, int friendLevelMinimun) {
        String inviteList = TextReader.readTxt(pathInviteList);
        Graph graph = ManagerGraph.createGraphPeopleByString(inviteList);
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

    private String getStringByEdgeList(List<Edge> edgeList) {
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

    private String getStringByGroups(List<Group> groups) {
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

    private int getWeightEdgeList(List<Edge> edgeList) {
        int totalWeight = 0;
        for (Edge currentEdge : edgeList) {
            totalWeight += currentEdge.getWeightFriendly();
        }
        return totalWeight;
    }

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

    private String getGroupWithBestFriendly(List<Group> groups) {
        return getGroupWithRelationship(groups, true);
    }

    private String getGroupWithLeastFriendly(List<Group> groups) {
        return getGroupWithRelationship(groups, false);
    }


    public String generateBestPartyPlan(String pathInviteList, int friendLevelMinimun, int quantityGroups) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Edge> listEdges = calculateBestGroup(pathInviteList, friendLevelMinimun);
        stringBuilder.append("Guests:\n");
        stringBuilder.append(getStringByEdgeList(listEdges) + "\n");
        Graph invites = ManagerGraph.createGraphByEdgeList(listEdges);
        List<Group> groups = GreedySpanningTree.getBestGroups(invites, quantityGroups);
        stringBuilder.append("Group:\n");

        stringBuilder.append(groups.size()).append("\n");

        stringBuilder.append(getStringByGroups(groups));
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
