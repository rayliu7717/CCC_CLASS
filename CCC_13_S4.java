import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

public class CCC_13_S4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer>[] graph = new List[n+1];
        for (int i = 0; i <=n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            graph[scanner.nextInt()].add(scanner.nextInt());
        }
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        boolean[] visited = new boolean[n+1];
        if(bfs(graph, p, q, visited))
            System.out.print("yes");
        else{
            Arrays.fill(visited, false);
            if(bfs(graph, q, p, visited))
                System.out.print("no");
            else
                System.out.print("unknown");
        }
    }
    private static boolean bfs(List<Integer>[] graph, int p, int q, boolean[] visited) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.push(p);
        visited[p] = true;
        while (!queue.isEmpty()) {
            int a = queue.pop();
            if (a == q) {
                return true;
            }
            for (int b : graph[a]) {
                if (!visited[b]) {
                    queue.offer(b);
                    visited[b] = true;
                }
            }
        }
        return false;
    }
}