import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
		ArrayList[] adj = new ArrayList[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
		int x = scanner.nextInt(), y = scanner.nextInt();
		while (x != 0 && y != 0) {
			adj[x].add(y);
			x = scanner.nextInt();
			y = scanner.nextInt();
		}
		dp[1] = 1;
		for (int i = 1; i <= N; i++) {
			for (int v : (ArrayList<Integer>) adj[i]) {
				dp[v] += dp[i];
			}
		}
		System.out.println(dp[N]);
    }
}
