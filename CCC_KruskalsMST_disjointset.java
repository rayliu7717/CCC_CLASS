// Java program for Kruskal's algorithm
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalsMST {
    // Defines edge structure
    static class Edge {
        int src, dest, weight;
        public Edge(int src, int dest, int weight)
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    // Function to find the MST 
    private static void kruskals(int V, List<Edge> edges)
    {
        int j = 0;
        int noOfEdges = 0;
        // Allocate memory for creating V subsets 
        int disjointSet[] = new int[V];
        // Allocate memory for results 
        Edge results[] = new Edge[V];
        // Create V subsets with single elements 
        for (int i = 0; i < V; i++) {
            disjointSet[i] = -1;
        }
        // Number of edges to be taken is equal to V-1 
        while (noOfEdges < V - 1) {
            // Pick the smallest edge. And increment 
            // the index for next iteration 
            Edge nextEdge = edges.get(j);
            int x = findRoot(disjointSet, nextEdge.src);
            int y = findRoot(disjointSet, nextEdge.dest);
            // If including this edge doesn't cause cycle, 
            // include it in result and increment the index 
            // of result for next edge 
            if (x != y) {
                results[noOfEdges] = nextEdge;
                union(disjointSet, x, y);
                noOfEdges++;
            }
            j++;
        }
        // Print the contents of result[] to display the 
        // built MST 
        System.out.println(
                "Following are the edges of the constructed MST:");
        int minCost = 0;
        for (int i = 0; i < noOfEdges; i++) {
            System.out.println(results[i].src + " -- "
                    + results[i].dest + " == "
                    + results[i].weight);
            minCost += results[i].weight;
        }
        System.out.println("Total cost of MST: " + minCost);
    }
    // Function to unite two disjoint sets 
    private static void union(int[] disjointSet, int x,
                              int y)
    {
        int rootX = findRoot(disjointSet, x);
        int rootY = findRoot(disjointSet, y);
        if (disjointSet[rootY] <= disjointSet[rootX]) {
            disjointSet[rootY] += disjointSet[rootX];
            disjointSet[rootX] = rootY;
        }
        else {
            disjointSet[rootX] += disjointSet[rootY];
            disjointSet[rootY] = rootX;
        }
    }
    // Function to find parent of a set 
    private static int findRoot(int[] disjointSet, int i)
    {
        if (disjointSet[i] < 0)
            return i;
        return  findRoot(disjointSet, disjointSet[i]);
    }
    // Starting point of program execution
    public static void main(String[] args)
    {
        int V = 8;
        List<Edge> graphEdges = new ArrayList<Edge>(
                List.of(new Edge(0, 1, 5), new Edge(0, 2, 5),
                        new Edge(1, 3, 1), new Edge(1, 5, 9),
                        new Edge(1, 6, 8), new Edge(2, 5, 5),
                        new Edge(3, 5, 3), new Edge(3, 7, 6),
                        new Edge(4, 6, 7), new Edge(4, 7, 3),
                        new Edge(5, 6, 1)) );
        graphEdges.sort(new Comparator<Edge>() {
            @Override public int compare(Edge o1, Edge o2)
            {
                return o1.weight - o2.weight;
            }
        });
        kruskals(V, graphEdges);
    }
} 