import java.io.*;
import java.util.*;


public class CCC_02s4 {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int M=scanner.nextInt(), Q=scanner.nextInt();
        int[] time = new int[Q]; String[] names = new String[Q];
        for (int i=0; i<Q; i++) {
            names[i]= scanner.next();
            time[i]=scanner.nextInt();
        }
        int[] dp = new int[Q+1], group=new int[Q+1];
        for (int i=0; i<=Q; i++) {
            dp[i]=(int)1e6; group[i]=-1;
        }
        dp[0]=group[0]=0;
        for (int i=0; i<=Q; i++) {
            int slowest_so_far=0;
            for (int j=i+1; j-i<=M && j<=Q; j++) {
                slowest_so_far=Math.max(slowest_so_far, time[j-1]);
                if (dp[j]>dp[i]+slowest_so_far) { // if we found a quicker option
                    dp[j]=dp[i]+slowest_so_far;
                    group[j] = j-i; // this group has length j-i
                }
            }
        }
        System.out.println("Total Time: "+dp[Q]);
        int [] lines = new int [Q+1];
        int i=0, x=0;
        while (group [Q] != 0)
        {
            lines [i++] = group [Q];
            Q=Q-group[Q];
        }
        for (i--; i>= 0 ; i--) {
            for (int j = 0 ; j < lines [i] ; j++) System.out.print(names[x++]+" ");
            System.out.println();
        }
    }
}