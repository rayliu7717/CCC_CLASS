import java.io.*;
import java.util.*;

public class Main {
    static char[][] grid;
    static int[][] ans;
    static boolean[][] cc;  // camera caught cell  
    static Map<Character,int[]> c2Dir;
    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    static int n,m,x0,y0;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();m= scanner.nextInt();
        grid = new char[n][m];
        ans = new int[n][m];
        cc = new boolean[n][m];
        for(int [] a : ans) Arrays.fill(a,Integer.MAX_VALUE);
         
        c2Dir = new HashMap<>();
        c2Dir.put('R',dir[0]);
        c2Dir.put('D',dir[1]);
        c2Dir.put('U',dir[2]);
        c2Dir.put('L',dir[3]);
        ArrayList<int[]> cam = new ArrayList<>();
        ArrayList<int[]> dest = new ArrayList<>();
        for(int i=0;i<n;i++){
            String tmp = scanner.next();
            for(int j=0;j<m;j++){
                grid[i][j] = tmp.charAt(j);
                if(grid[i][j]=='S'){x0 = i;y0 = j;grid[i][j] = '.';}
                else if(grid[i][j]=='C'){cam.add(new int[]{i,j});}
                else if(grid[i][j]=='.'){dest.add(new int[]{i,j});}
            }
        }
        for(int[] cur:cam){
            markCC(cur[0],cur[1]);
        }
        bfs();
        for(int[] a:dest){
            if (ans[a[0]] [a[1]] < Integer.MAX_VALUE)
                System.out.println(ans[a[0]] [a[1]]);
            else
                System.out.println(-1);
        }
    }
    static void bfs(){
        if(cc[x0][y0])
            return;
        Queue<int[]> q = new LinkedList<>();
        int[] start = {x0,y0};
        q.add(start);
        ans[x0][y0] =0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            int [][] curDir;
            int step = 1;
            if(grid[x][y]=='.')
                curDir = dir;
            else{
                step = 0;
                curDir = new int[1][2];
                curDir[0] = c2Dir.get(grid[x][y]);
            }
            for(int[] nxt:curDir){
                int x1 = x + nxt[0], y1= y+nxt[1];
                if(inMoveRange(x1,y1)&& grid[x1][y1]!='W' && !cc[x1][y1] ){
                    if( ans[x1][y1] > ans[x][y]+ step){
                        ans[x1][y1] = ans[x][y]+step;
                        q.add(new int[]{x1,y1});
                    }
                }
            }
        }
    }
    static boolean inMoveRange(int x,int y){
        return x>0&&x<n-1&&y>0&&y<m-1;
    }
    
    // mark Camera caught cells
    static void markCC (int x,int y){ 
        for(int i=x+1;i<n-1 && grid[i][y]!='W';i++){
            if(grid[i][y]=='.'){cc[i][y] = true;}
        }
        for(int i=x-1;i>0 && grid[i][y]!='W';i--){
            if(grid[i][y]=='.'){cc[i][y] = true;}
        }
        for(int i=y+1;i<m-1 && grid[x][i]!='W';i++){
            if(grid[x][i]=='.'){cc[x][i] = true;}
        }
        for(int i=y-1;i>0 && grid[x][i]!='W';i--){
            if(grid[x][i]=='.'){cc[x][i] = true;}
        }
        cc[x][y] = true;
    }
}