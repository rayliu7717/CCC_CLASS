import java.io.*;
import java.util.*;
public class CCC_21_S4 {
    static int MAXN=200000;
    // using BFS to set the walk distance to station N from every station.
    public static void bfs(int start, ArrayList<Integer> [] adj, int[] walkDistances) {
        Queue<Integer> queue = new LinkedList<>();
        boolean [] vis = new boolean[start+1];  // start is station N
        queue.add(start);
        walkDistances[start] = 0;
        vis[start] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj[u]) {
                if(!vis[v]){
                    queue.add(v);
                    walkDistances[v] = walkDistances[u] + 1;
                    vis[v] = true;
                }
            }
        }
    }

    // Implement  Comparable interface
    static class Pair implements Comparable<Pair>{
        int dist;  // walk distance from this station number to station N
        int id;   // station number, not index
        public Pair(int dist, int id){
            this.id = id;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair pair) {
            if(this.dist != pair.dist)
                return  this.dist - pair.dist;
            return this.id - pair.id;
        }
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int W = scanner.nextInt();
        int D = scanner.nextInt();
        ArrayList<Integer> [] adj = new ArrayList[N + 1];
        int [] walkDistances = new int[N+1];
        int [] trainStations = new int[N+1];
        int [] trainDistances = new int[N+1];
        Set<Pair> totalDistanceSet = new TreeSet<>();
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
            walkDistances[i] = MAXN;
        }
        for (int i = 0; i < W; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj[v].add(u);
        }
        
        bfs(N, adj, walkDistances);
        for (int i = 1; i <= N; i++) {
            int u = scanner.nextInt();
            trainStations[i] = u;
            trainDistances[u] = i -1;   // index of the array is the distance to that station 
        }
        for (int stationNo = 1; stationNo <= N ; stationNo++) {
            if(walkDistances[stationNo] < MAXN)
                totalDistanceSet.add(new Pair(trainDistances[stationNo] + walkDistances[stationNo], stationNo));  // set for every station number
            // st is current sorted commute time for each station.
        }

        for (int i = 1; i <= D; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            int sx = trainStations[x];
            int sy = trainStations[y];
            if(walkDistances[sx] < MAXN)
                totalDistanceSet.remove( new Pair(trainDistances[sx] + walkDistances[sx], sx));
            if(walkDistances[sy] < MAXN)
                totalDistanceSet.remove( new Pair(trainDistances[sy] + walkDistances[sy], sy));
            int temp = trainDistances[sx];
            trainDistances[sx] = trainDistances[sy];
            trainDistances[sy] = temp;
            temp = trainStations[x];
            trainStations[x] = trainStations[y];
            trainStations[y] = temp;
            if(walkDistances[sx] < MAXN)
                totalDistanceSet.add(new Pair(trainDistances[sx] + walkDistances[sx], sx));
            if(walkDistances[sy] < MAXN)
                totalDistanceSet.add(new Pair(trainDistances[sy] + walkDistances[sy], sy));
            System.out.println(totalDistanceSet.iterator().next().dist);
        }
    }
}
