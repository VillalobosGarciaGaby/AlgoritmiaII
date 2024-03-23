package org.example.AudiesParty.DataStructure;
import org.example.AudiesParty.Model.Edge;
import org.example.AudiesParty.Model.Group;
import org.example.AudiesParty.Model.Nodo;
import org.example.AudiesParty.Utils.TextReader;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CalculatorAudieParty {

    public List<Edge> calculateBestGroup(String pathInviteList, int friendLevelMinimun){
        String inviteList = TextReader.readTxt(pathInviteList);
        Graph graph = ManagerGraph.createGraphPeopleByString(inviteList);
        List<Edge> bestList = null;
        List<Edge> currentList;
        for(int i = 0; i < graph.getNodos().size(); i++){
            currentList = GreedySpanningTree.maxSpanningTree(graph, friendLevelMinimun, i);
            if((i == 0 ) || (currentList.size() > bestList.size() && getWeightEdgeList(currentList)>getWeightEdgeList(bestList))){
                bestList = currentList;
            }
        }
        return bestList;
    }

    private String getStringByEdgeList(List<Edge> edgeList){
        Set<String> names = new TreeSet<>();
        for(Edge currentEdge: edgeList){
            names.add(currentEdge.nodoA.getNamePeople());
            names.add(currentEdge.nodoB.getNamePeople());
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String current: names){
            stringBuilder.append(current).append(" ");
        }
        return stringBuilder.toString();
    }

    private String getStringByGroups( List<Group> groups ){
        StringBuilder stringBuilder = new StringBuilder();
        if(groups.isEmpty()){
            stringBuilder.append("It is not possible");
        }
        for(Group currentGroup: groups){
            for(Nodo nodo : currentGroup.getNodos()){
                stringBuilder.append(nodo.getNamePeople() + " ");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private  int getWeightEdgeList(List<Edge> edgeList){
        int totalWeight = 0;
        for(Edge currentEdge : edgeList){
            totalWeight += currentEdge.getWeightFriendly();
        }
        return totalWeight;
    }

    private Group getGroupWithBestFriendly(Group current, Group selectedGroup){
        if(current.getBestGroup() > selectedGroup.getBestGroup())selectedGroup = current;
        return selectedGroup;
    }

    private Group getGroupWithLeastFriendly(Group current, Group selectedGroup){
        if(current.getLeastGroup() < selectedGroup.getLeastGroup()) selectedGroup = current;
        return selectedGroup;

    }

    private String getGroup(List<Group> groups, boolean bestGroup){
        StringBuilder stringBuilder = new StringBuilder();
        Group selectedGroup = groups.get(0);
        Group current;
        for(Group group: groups){
            if(!group.getEdges().isEmpty()){
                current = group;
                if(bestGroup) selectedGroup = getGroupWithLeastFriendly(current, selectedGroup);
                else selectedGroup = getGroupWithBestFriendly(current, selectedGroup);
                if(current.getLeastGroup() < selectedGroup.getLeastGroup()){
                    selectedGroup = current;
                }
            }
        }

        for(Nodo nodo : selectedGroup.getNodos()){
            if(selectedGroup.getNodos().size() == 1){
                stringBuilder.append("None");
                continue;
            }
            stringBuilder.append(nodo.getNamePeople() + " ");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public String generateBestPartyPlan(String pathInviteList, int friendLevelMinimun, int quantityGroups){
        StringBuilder stringBuilder = new StringBuilder();
        List<Edge> listEdges = calculateBestGroup(pathInviteList, friendLevelMinimun);
        stringBuilder.append("--------------------------------------------------\n");
        stringBuilder.append("Guests:\n");
        stringBuilder.append(getStringByEdgeList(listEdges)+"\n");
        Graph invites = ManagerGraph.createGraphByEdgeList(listEdges);
        List<Group> groups = GreedySpanningTree.getBestGroups(invites, quantityGroups);
        stringBuilder.append("GROUPS:\n");

        stringBuilder.append(groups.size()).append("\n");

        stringBuilder.append(getStringByGroups(groups));
        if(!groups.isEmpty()){
            String groupWithBestFriendly = getGroup(groups, true);
            String groupWithLeastFriendly = getGroup(groups, false);
            stringBuilder.append("Group with strongest friendly relationship: " + groupWithBestFriendly);
            stringBuilder.append("Group with least friendly relationship: "+ groupWithLeastFriendly);
        }
        stringBuilder.append("--------------------------------------------------\n");
        return stringBuilder.toString();
    }
}
