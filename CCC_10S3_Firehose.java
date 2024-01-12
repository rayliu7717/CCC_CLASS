import java.io.*;
import java.util.*;

public class Main {
    private static int[] houses;
    private static int H;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        H = scanner.nextInt();
        houses = new int[H * 2];
        for (int i = 0; i < H; i++) {
            houses[i] = scanner.nextInt();
        }
        Arrays.sort(houses, 0, H);
        for (int i = 0; i < H; i++) {
            houses[i + H] = houses[i] + 1000000;
        }
        int K = scanner.nextInt();
        int lo = 0;
        int hi = 1000000;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (getMinHoseCount(mid) > K) lo = mid + 1;
            else hi = mid;
        }
        System.out.println(lo);

    }
    private static int getMinHoseCount(int len) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < H; i++) {
            int cur = i;
            int h = 1;
            for (int j = i; j < H + i; j++) {
                if (houses[j] - houses[cur] > 2 * len) {
                    cur = j;
                    h++;
                }
            }
            min = Math.min(min, h);
        }
        return min;
    }
}
