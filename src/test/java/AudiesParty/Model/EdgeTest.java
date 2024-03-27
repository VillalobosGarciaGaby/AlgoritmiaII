package AudiesParty.Model;
import AudiesParty.Model.Edge;
import AudiesParty.Model.Nodo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EdgeTest {

    @Test
    void constructor_InitializesNodesAndWeight() {
        Nodo nodoA = new Nodo("Alice");
        Nodo nodoB = new Nodo("Bob");
        Edge edge = new Edge(nodoA, nodoB, 10);

        assertEquals(nodoA, edge.getNodoA());
        assertEquals(nodoB, edge.getNodoB());
        assertEquals(10, edge.getWeightFriendly());
    }

    @Test
    void getOtherNode_ReturnsOtherNode() {
        Nodo nodoA = new Nodo("Alice");
        Nodo nodoB = new Nodo("Bob");
        Edge edge = new Edge(nodoA, nodoB, 10);

        assertEquals(nodoB, edge.getOtherNode(nodoA));
        assertEquals(nodoA, edge.getOtherNode(nodoB));
    }

    @Test
    void getOtherNode_ThrowsExceptionForInvalidNode() {
        Nodo nodoA = new Nodo("Alice");
        Nodo nodoB = new Nodo("Bob");
        Nodo nodoC = new Nodo("Charlie");
        Edge edge = new Edge(nodoA, nodoB, 10);

        assertThrows(IllegalArgumentException.class, () -> {
            edge.getOtherNode(nodoC);
        });
    }

    @Test
    void compareTo_ReturnsZeroForEqualEdges() {
        Nodo nodoA = new Nodo("Alice");
        Nodo nodoB = new Nodo("Bob");
        Edge edge1 = new Edge(nodoA, nodoB, 10);
        Edge edge2 = new Edge(nodoA, nodoB, 10);

        assertEquals(0, edge1.compareTo(edge2));
    }

    @Test
    void compareTo_ReturnsPositiveForGreaterEdge() {
        Nodo nodoA = new Nodo("Alice");
        Nodo nodoB = new Nodo("Bob");
        Edge edge1 = new Edge(nodoA, nodoB, 10);
        Edge edge2 = new Edge(nodoA, nodoB, 5);

        assertTrue(edge1.compareTo(edge2) > 0);
    }

    @Test
    void compareTo_ReturnsNegativeForLesserEdge() {
        Nodo nodoA = new Nodo("Alice");
        Nodo nodoB = new Nodo("Bob");
        Edge edge1 = new Edge(nodoA, nodoB, 5);
        Edge edge2 = new Edge(nodoA, nodoB, 10);

        assertTrue(edge1.compareTo(edge2) < 0);
    }
}
