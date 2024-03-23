# Greedy Proyect
### Gabriela Garcia Villalobos

## 1. Write a brief explanation of why you have chosen the greedy algorithm to solve the problem. (a) If you use a new algorithm, include the correctness proof; otherwise, you only need to mention the algorithm’s name.

#### Algorithm Explanation
   - The chosen algorithm to solve the problem is the Prim and Spanning Tree Algorithm. This algorithm is selected because it efficiently finds the maximum spanning tree in a graph given a certain constraint on the edge weights.
   - The main idea behind the Prim and Spanning Tree Algorithm is to iteratively select the edge with the maximum weight that satisfies the given constraint, ensuring that no cycles are formed in the process. By doing so, it constructs a tree that spans all the nodes in the graph while maximizing the total weight of the edges.

Antes
![Evidencia2.png](Pictures%2FEvidencia2.png)

Despues
![Evidencia.png](Pictures%2FEvidencia.png)

Evitando
![Evidencia3.png](Pictures%2FEvidencia3.png)


#### Code Structure
   - The solution is divided into several Java classes organized under the org.example.AudiesParty package:

   - CalculatorAudieParty: This class contains the main logic for calculating the best group for an Audie party. It utilizes the Greedy Spanning Tree Algorithm to find the maximum spanning tree within the graph of invitees.
   - Graph: Represents the graph data structure consisting of nodes (Node) and edges (Edge).
   - GreedySpanningTree: Contains the implementation of the Prim and Spanning Tree Algorithm to find the maximum spanning tree in a graph.
   - ManagerGraph: Provides utility methods for creating graphs from input data.
   - Edge: Represents an edge in the graph, containing information about the connected nodes and the weight.
   - Group: Represents a group of nodes within the graph, along with their associated edges and characteristics.
   - Node: Represents a node in the graph, identified by a name and containing a list of adjacent edges.


## 2. Identify the time complexity of your solution.

### Time Complexity
The time complexity of the solution can be analyzed based on the operations performed in the Greedy Spanning Tree Algorithm:

   - Building the Priority Queue: O(E log E), where E is the number of edges in the graph.
   - Iterating over the Edges: O(E), as each edge is considered once.
   - Total Time Complexity: O(E log E)

### Conclusion
In conclusion, the chosen prim and Spanning Tree Algorithm efficiently addresses the problem requirements by finding the maximum spanning tree within the graph of invitees. The algorithm's correctness and efficiency make it suitable for solving this problem.

