import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class CCC_14_S4 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), t = scanner.nextInt();
        int [][] windows = new int [n][5];
        TreeMap<Integer, Integer>x = new TreeMap();
        TreeMap<Integer, Integer> y = new TreeMap();
        for(int i =0;i<n;i++) {
            for(int j = 0;j<5;j++)windows[i][j] = scanner.nextInt();
            x.put(windows[i][0],0);
            x.put(windows[i][2],0);
            y.put(windows[i][1],0);
            y.put(windows[i][3],0);
        }
        int idx = 1;
        int [] xVal = new int[2*n+2];
        int [] yVal = new int[2*n+2];
        for(Entry<Integer, Integer> e: x.entrySet()) {
            e.setValue(idx);
            xVal[idx++]= e.getKey();
        }
        idx = 1;
        for(Entry<Integer,Integer>e: y.entrySet()) {
            e.setValue(idx);
            yVal[idx++]= e.getKey();
        }
        int[][]dif = new int[n*2+2][n*2+2];
        for(int i =0;i<n;i++) {
            int x1 = x.get(windows[i][0]);
            int y1 = y.get(windows[i][1]);
            int x2 = x.get(windows[i][2]);
            int y2 = y.get(windows[i][3]);
            int v = windows[i][4];
            dif[x1][y1]+= v;
            dif[x2][y1]-= v;
            dif[x1][y2]-= v;
            dif[x2][y2]+= v;
        }
        long ans = 0;
        for(int i =1;i<=x.size();i++) {
            for(int j = 1;j<=y.size();j++) {
                dif[i][j] += dif[i-1][j]+dif[i][j-1]-dif[i-1][j-1];
                if(dif[i][j] >= t ) {
                    ans+= (long)(xVal[i+1]-xVal[i])*(yVal[j+1]- yVal[j]);
                }
            }
        }
        System.out.println(ans);
    }
}