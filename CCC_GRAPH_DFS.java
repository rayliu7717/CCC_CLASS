// Java program to print DFS traversal from a given graph
import java.util.*;

// This class represents a
// directed graph using adjacency
// list representation
class CCC_GRAPH_DFS {
    private int V;

    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    CCC_GRAPH_DFS(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        // Add w to v's list.
        adj[v].add(w);
    }

    // A function used by DFS
    void DFS(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFS(n, visited);
        }
    }

    public static void main(String args[])
    {
        CCC_GRAPH_DFS g = new CCC_GRAPH_DFS(8);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 5);
        g.addEdge(3, 5);
        g.addEdge(4, 2);
        g.addEdge(4, 6);
        g.addEdge(5, 1);
        g.addEdge(6, 7);
        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 0)");

        // Mark all the vertices as
        // not visited(set as
        // false by default in java
        boolean visited[] = new boolean[8];
        g.DFS(0, visited);
    }
}