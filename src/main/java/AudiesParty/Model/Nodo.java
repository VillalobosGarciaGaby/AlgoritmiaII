package AudiesParty.Model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter

public class Nodo {
    private String namePeople;
    private ArrayList<Edge> edges;
    private boolean inAGroup;

    public Nodo(String namePeople){
        this.namePeople = namePeople;
        edges = new ArrayList<>();
        inAGroup = false;
    }

    @Override
    public String toString() {
        return ("Node{" +
                "name='" + namePeople);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo nodo = (Nodo) o;
        return inAGroup == nodo.inAGroup && Objects.equals(namePeople, nodo.namePeople) && Objects.equals(edges, nodo.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePeople, edges);
    }
}
