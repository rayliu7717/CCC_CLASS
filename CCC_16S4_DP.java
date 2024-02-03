import java.util.*;
import java.io.*;
public class CCC_16S4_DP{
    public static void calc ( int n, int [] a, int[][]dp )
    {
        for(int len = 1; len < n; ++len)
        {
            for(int l = 0; l < n-len; ++l)
            {
                int r = l +len;
                if (r == l + 1 ){
                    if( a[l] == a[r])
                        dp[l][r] = Math.max(dp[l][r], a[l] + a[r]);
                    continue;
                }
                else if (r == l + 2 && a[l] == a[r]) {
                    dp[l][r] = a[l] * 2 + a[l + 1];
                    continue;
                }
                else {
                    for (int i = l; i < r; i++) {
                        int left = dp[l][i];
                        if (left > 0) {
                            int right = dp[i + 1][r];
                            if (left == right) {
                                dp[l][r] = left + right;
                                break;
                            }
                            for (int j = i + 2; j <= r; ++j) {
                                right = dp[j][r];
                                if (right > 0 && right == left) {
                                    int middle = dp[i + 1][j - 1];
                                    if (middle > 0) {
                                        dp[l][r] = left + right + middle;
                                        break;
                                    }
                                }
                            }
                            if (dp[l][r] > 0)
                                break;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[]args) throws NumberFormatException, IOException{
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int [] a = new int [N];
        int[][] dp = new int[N+1][N+1];
        int out = 0;
        for(int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
            dp[i][i] = a[i];
            if(out<a[i])
                out = a[i];
        }
        calc(N, a, dp);
        for(int len = N - 1; len>0; len--){
            for(int l = 0;l < N- len; ++l){
                int r = l+ len;
                int m = dp[l][r];
                out = Math.max(out, m);
            }
        }

        System.out.println(out);
    }
}