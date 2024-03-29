import java.io.*;
import java.util.*;
// Java program to print BFS traversal from a given source
// vertex. BFS(int s) traverses vertices reachable from s.
// This class represents a directed graph using adjacency
// list representation
// It starts at the root of the graph and visits all nodes at the current depth level before moving on to the nodes at the next depth level.
class CCC_GRAPH_BFS {
        private int V;  // No. of vertices
        private LinkedList<Integer> adj[]; // Adjacency Lists 
        
        CCC_GRAPH_BFS(int v) // Constructor
        {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) { adj[v].add(w); }

        // prints BFS traversal from a given source s
        void BFS(int s)
        {
            // Mark all the vertices as not visited(By default
            // set as false)
            boolean visited[] = new boolean[V];
            // Create a queue for BFS
            Queue<Integer> queue
                    = new LinkedList<Integer>();
            // Mark the current node as visited and enqueue it
            visited[s] = true;
            queue.add(s);
            while (queue.size() != 0) {
                // Dequeue a vertex from queue and print it
                s = queue.poll();
                System.out.print(s + " ");
                // Get all adjacent vertices of the dequeued
                // vertex s.
                // If an adjacent has not been visited,
                // then mark it visited and enqueue it
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }

        // Driver code
        public static void main(String args[])
        {
            CCC_GRAPH_BFS g = new CCC_GRAPH_BFS(8);
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
                    "Following is Breadth First Traversal "
                            + "(starting from vertex 0)");
            g.BFS(0);
        }
}
