import java.io.*;
import java.util.*;

public class Main {

    public static long getSum(long p,  long[] P, int[] W, long[] D  ){
        long sum = 0;
        for(int i = 0;i<P.length; ++i){
            long dist = Math.abs(p - P[i]);
            if(dist > D[i])
                sum += W[i] * (dist - D[i]);
        }
        return sum;
    }
    public static long binary_search(long left, long right, long[] P, int[] W, long[] D)
    {
        long t = 0;
        if(left == right)
            t = getSum(left, P, W, D);
        else if(right - left == 1){
            t = Math.min(getSum(left,P,W, D), getSum(right,P,W,D));
        }
        else if(right - left == 2){
            t = Math.min(getSum(left,P,W, D), getSum(right,P,W,D));
            t = Math.min(getSum(left + 1,P,W, D), t);
        }
        else{
            long mid = left + Math.floor((right-left)/2);
            long m = getSum(mid, P, W, D);
            long m_1 = getSum(mid -1, P, W, D);  // m-1
            long m1 = getSum(mid +1, P, W, D);   // m+1
            if( m <= m_1 && m<=m1)
                t = m;
            else if(m < m_1)
                t = binary_search(mid, right,P, W,D);
            else
                t = binary_search(left, mid,P, W,D);
        }
        return t;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long left = 0;
        long right = 0;
        long[] P = new long[N];
        int[] W = new int[N];
        long[] D = new long[N];
        for(int i=0;i<N; ++i){
            P[i] = scanner.nextLong();
            W[i] = scanner.nextInt();
            D[i] = scanner.nextLong();
            if(i == 0){
                left = right = P[i];
            }
            else{
                if(P[i]< left) left =P[i];
                if(P[i]> right) right = P[i];
            }
         }
        long result =  binary_search(left, right, P, W, D);
        System.out.println(result);
    }
}