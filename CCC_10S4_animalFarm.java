import java.util.*;
import java.io.*;
public class CCC_10_S4{
    static int FindRoot(int x, int[] p){
        if(p[x]!=x){
            p[x]=FindRoot(p[p[x]], p);
        }
        return p[x];
    }
    static void Union(int x, int y, int[] p, int[] rank){
        if(rank[x]>rank[y])p[y]=x;
        else{
            p[x]=y;
            if(rank[x]==rank[y]) rank[y]++;
        }
    }
    static int kruskalMSTCost( int M, PriorityQueue <PenEdge> q)
    {
        int [] p = new int[M+1]; 
        int [] rank = new int[M+1];
        for (int i = 0; i<=M; i++) 
            p[i] = i;
        int minCost = 0;
        while(!q.isEmpty()){
            PenEdge e = q.remove();
            int u = FindRoot(e.u, p), v = FindRoot(e.v,p);
            if (u!=v){
                Union(u , v, p, rank);
                minCost+=e.w;
            }
        }
        return minCost;
    }

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int ans = 0;
        PriorityQueue <CornerEdge> pq = new PriorityQueue<CornerEdge>();
        PriorityQueue <PenEdge> pq1 = new PriorityQueue<PenEdge>(), pq2 = new PriorityQueue<PenEdge>();
        for (int i = 1; i<=M; i++){
            int e = scanner.nextInt();
            int[] pen = new int[e+1];
            for (int j = 1; j<=e; j++){
                pen[j]=scanner.nextInt();
            }
            for (int j = 1; j<e; j++){
                int w = scanner.nextInt();
                int u = Math.min(pen[j], pen[j+1]), v = Math.max(pen[j], pen[j+1]);
                pq.add(new CornerEdge(u, v, w, i));
            }
            int w = scanner.nextInt();
            int u = Math.min(pen[e], pen[1]), v = Math.max(pen[e], pen[1]);
            pq.add(new CornerEdge(u, v, w, i));
        }
        while(!pq.isEmpty()){
            CornerEdge e = pq.remove();
            if(!pq.isEmpty()&&pq.peek().u==e.u&&pq.peek().v==e.v){
                CornerEdge e1 = pq.remove();
                pq1.add(new PenEdge(e.p, e1.p, e.w));
                pq2.add(new PenEdge(e.p, e1.p, e.w));
            }
            else{
                pq2.add(new PenEdge(e.p, 0, e.w));
            }
        }
        int ans1 = kruskalMSTCost(M, pq1);
        int ans2 = kruskalMSTCost(M, pq2);
        System.out.println(Math.min(ans1, ans2));
    }
    static class CornerEdge implements Comparable <CornerEdge>{
        int u, v, w, p;
        CornerEdge (int u1, int v1, int w1, int p1){u=u1; v=v1; w=w1; p=p1;}
        public int compareTo(CornerEdge e) {
            if (this.u<e.u||(this.u==e.u&&this.v<e.v)) return -1;
            else return 1;
        }
    }
    static class PenEdge implements Comparable <PenEdge>{
        int u, v, w;
        PenEdge (int u1, int v1, int w1){u=u1;v=v1;w=w1;}
        public int compareTo(PenEdge e) {
            if(this.w<e.w) return -1;
            else return 1;
        }
    }
}