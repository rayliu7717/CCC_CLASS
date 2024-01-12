import java.util.*;
public class CCC_Dijkstra {
    public static void main(String[] args) {
        int V = 8;
        Graph g = new Graph(V);
        // Adding edges to create the graph
        g.addEdge(0, 1, 3);
        g.addEdge(0, 3, 9);
        g.addEdge(0, 4, 6);
        g.addEdge(1, 0, 3);
        g.addEdge(1, 3, 3);
        g.addEdge(1, 6, 8);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 6, 6);
        g.addEdge(3, 0, 9);
        g.addEdge(3, 1, 3);
        g.addEdge(4, 0, 6);
        g.addEdge(4, 6, 7);
        g.addEdge(4, 7, 8);
        g.addEdge(5, 2, 2);
        g.addEdge(5, 7, 2);
        g.addEdge(6, 1, 8);
        g.addEdge(6, 2, 6);
        g.addEdge(6, 4, 7);
        g.addEdge(6, 7, 6);
        g.addEdge(7, 4, 8);
        g.addEdge(7, 5, 2);
        g.addEdge(7, 6, 6);
        // Finding and printing the shortest paths from
        // source vertex 0
        g.shortestPath(0);
    }

    // Class to represent a graph and implement Dijkstra's
    // shortest path algorithm
    static class Graph {
        private int V; // Number of vertices
        private List<int[]>[] adj; // Adjacency list to store
        // graph edges

        // Inner class to represent a pair of vertex and its
        // weight
        class Pair implements Comparable<Pair> {
            int vertex, weight;
            Pair(int v, int w)
            {
                vertex = v;
                weight = w;
            }
            // Comparison method for priority queue
            public int compareTo(Pair other)
            {
                return Integer.compare(this.weight,
                        other.weight);
            }
        }
        // Constructor to initialize the graph
        Graph(int V)
        {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; ++i)
                adj[i] = new ArrayList<>();
        }
        // Method to add an edge to the graph
        void addEdge(int u, int v, int w)
        {
            adj[u].add(new int[] { v, w });
            adj[v].add(new int[] { u, w });
        }
        // Method to find the shortest paths from source vertex
        // to all other vertices
        void shortestPath(int src)
        {
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            pq.add(new Pair(src, 0));
            dist[src] = 0;
            // Dijkstra's algorithm
            while (!pq.isEmpty()) {
                int u = pq.poll().vertex;
                for (int[] neighbor : adj[u]) {
                    int v = neighbor[0];
                    int weight = neighbor[1];
                    // Relaxation step
                    if (dist[v] > dist[u] + weight) {
                        dist[v] = dist[u] + weight;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
            // Print shortest distances from source
            System.out.println("Vertex Distance from Source");
            for (int i = 0; i < V; ++i)
                System.out.println(i + "\t\t" + dist[i]);
        }
    }
}