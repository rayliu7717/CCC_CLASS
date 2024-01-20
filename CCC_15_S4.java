import java.io.*;
import java.util.*;

public class Main {
     static class Edge implements Comparable<Edge>{
        int dest,time,hull;
        Edge(int dest, int time, int hull){
            this.dest=dest;
            this.time=time;
            this.hull=hull;
        }
        public int compareTo(Edge a){
            if(this.time>a.time) return 1;
            if(this.time<a.time) return -1;
            return 0;
        }
    }
    
    public static void bfs(int start, int end, int K, ArrayList<Edge> [] graph,int [][] dis )
    {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(start,0,K));
        while(!q.isEmpty()){
            Edge a = q.poll();
            int e = a.dest;
            if(e==end) break;;
            for(Edge b : graph[e]){
                int time = a.time + b.time;
                int hull = a.hull - b.hull;
                int d = b.dest;
                if(hull > 0 && dis[d][hull]>time){
                    dis[d][hull]=time;
                    q.add(new Edge(d,time,hull));
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt(), N =scanner.nextInt(), M = scanner.nextInt();
        ArrayList<Edge> [] graph = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) graph[i]=new ArrayList<>();
        for(int i = 0; i < M; i++){
            int a = scanner.nextInt(), b = scanner.nextInt(), t = scanner.nextInt(), h = scanner.nextInt();
            graph[a].add(new Edge(b,t,h));
            graph[b].add(new Edge(a,t,h));
        }
        int start = scanner.nextInt(), end = scanner.nextInt();
        int [][] dis = new int[N+1][K+1];
        for(int [] a : dis) Arrays.fill(a,Integer.MAX_VALUE);
        bfs(start,end,K, graph,dis);
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < K+1; i++){
            if(dis[end][i]<min){
                min=dis[end][i];
            }
        }

        if(min==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);

    }
}