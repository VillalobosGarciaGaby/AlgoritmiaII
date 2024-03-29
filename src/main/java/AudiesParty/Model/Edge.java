package AudiesParty.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Edge implements Comparable<Edge>{
    public Nodo nodoA;
    public Nodo nodoB;
    public int weightFriendly;

    public Edge(Nodo origin, Nodo destiny, int weightFriendly) {
        this.nodoA = origin;
        this.nodoB = destiny;
        this.weightFriendly = weightFriendly;
    }

    public Nodo getOtherNode(Nodo nodo) {
        if (nodo.equals(nodoA)) {
            return nodoB;
        } else if (nodo.equals(nodoB)) {
            return nodoA;
        } else {
            throw new IllegalArgumentException("No es uno de los nodo de la arista.");
        }
    }

    @Override
    public String toString() {
        return nodoA.getNamePeople() + " -> " + nodoB.getNamePeople() + " = "+ weightFriendly;
    }

    @Override
    public int compareTo(Edge otherEdge) {
        return Integer.compare(this.weightFriendly, otherEdge.weightFriendly);
    }

}
