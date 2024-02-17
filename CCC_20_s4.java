import java.io.*;
import java.util.*;

public class Main {
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = s.length(), pa[] = new int[n+1], pb[] = new int[n+1], pc[] = new int[n+1];
        for(int i = 1; i <= n; i++){
            char c = s.charAt(i-1);
            if(c == 'A') pa[i] = 1;
            if(c == 'B') pb[i] = 1;
            if(c == 'C') pc[i] = 1;
            pa[i] += pa[i-1]; pb[i] += pb[i-1]; pc[i] += pc[i-1];
        }
        // prefix array of pa, pb, pb    
        int na = pa[n], nb = pb[n], nc = pc[n];
        // pa[n] is number of A
        
        for(int i = 1; i <= n; i++){
            if(i >= na+nb){
                check(pa, pb, i); check(pb, pa, i);
            }
            if(i >= na+nc){
                check(pa, pc, i); check(pc, pa, i);
            }
            if(i >= nb+nc){
                check(pb, pc, i); check(pc, pb, i);
            }
        }
        System.out.println(ans);
    }
    
    static void check(int a[], int b[], int i){   
        int na = a[a.length-1], nb = b[b.length-1];  // number of x, number of y     
/*
# of non A's in section A + # of non B's in section B 
 - min(# of A's in section B, # of B's in section A)
Note that C is not needed in this formula because if A and B are sorted, then C must be sorted as well

*/
        int swap = na - (a[i] - a[i-na])    // number of non A in section A 
                   + nb - (b[i-na] - b[i-na-nb]); // number of non B in section B
        swap -= Math.min (b[i] - b[i-na]    // number of B in section A
                          ,a[i-na] - a[i-nb-na]);  // number of A in section B
        ans = Math.min(ans, swap);
    }
    
}