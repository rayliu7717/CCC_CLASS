class Solution {
   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(n == 0 || K < 0 || flights == null || flights.length == 0 || flights[0].length != 3)  return -1;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>(n);
        for(int i = 0;i<n; ++i)
            graph.add( new ArrayList<Node>());
        for(int [] f : flights){
            graph.get(f[0]).add(new Node(f[1],f[2],0));
        }
        int[][] dist = new int[n][K + 2];
        Arrays.stream(dist).forEach(A -> Arrays.fill(A, Integer.MAX_VALUE / 2));
        PriorityQueue<Node> que = new PriorityQueue<Node>((a, b) -> a.cost-b.cost);
        que.add(new Node(src, 0, 0));
        while(!que.isEmpty()){
            Node cur = que.poll();
            if(cur.city == dst)  return cur.cost;
            if(cur.stop >=  K + 1) continue;
            if(dist[cur.city][cur.stop] < Integer.MAX_VALUE / 2)
                continue;
            dist[cur.city][cur.stop] = cur.cost; 
            ArrayList<Node> nexts = graph.get(cur.city);
            for(Node nextCity : nexts){
                if(dist[nextCity.city][nextCity.stop + 1] < Integer.MAX_VALUE / 2)
                    continue;
                que.add(new Node(nextCity.city, cur.cost+nextCity.cost, cur.stop+1));
            }
        }
        return -1;
    }
}
class Node{
    int city;
    int cost;
    int stop;
    public Node(int city, int cost, int stop){
        this.city = city;
        this.cost = cost;
        this.stop = stop;
    }
}