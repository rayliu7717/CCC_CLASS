import java.util.*;
import java.io.*;
public class CCC_16S4_DFS{
    static int [][] cache;
    public static int dfsmerge (int [] a, int l, int r){
        if(cache[l][r] >= 0)
            return cache[l][r];
        if(cache[l][r] < 0)
            cache[l][r] = 0;

        if(r == l + 1 && a[l] == a[r])
            cache[l][r] = Math.max(cache[l][r], a[l] + a[r]);
        else if(r == l+2 && a[l] == a[r])
            cache[l][r] = a[l] * 2 + a[l + 1];
        else {
            for (int i = l; i < r; i++) {
                int left = dfsmerge(a, l, i);
                if (left > 0) {
                    int right = dfsmerge(a, i + 1, r);
                    if (left == right) {
                        cache[l][r] = left + right;
                        break;
                    }
                    for (int j = i + 2; j <= r; ++j) {
                        right = dfsmerge(a, j, r);
                        if (right > 0 && right == left) {
                            int middle = dfsmerge(a,i+1,j-1);
                            if(middle > 0) {
                                cache[l][r] = left + right + middle;
                                return cache[l][r];
                            }
                        }
                    }
                }
            }
        }
        return cache[l][r];
    }

    public static void main(String[]args) throws NumberFormatException, IOException{
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int [] a = new int [N];
        cache = new int[N+1][N+1];

        int out = 0;
        for(int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
            Arrays.fill(cache[i], -1);
            cache[i][i] = a[i];
            if(out<a[i])
                out = a[i];
        }
        for(int len = N - 1; len>0; len--){
            for(int l = 0;l < N- len; ++l){
                int r = l+ len;
                int m = dfsmerge(a, l,r);
                out = Math.max(out, m);
            }
        }
        System.out.println(out);
    }
}