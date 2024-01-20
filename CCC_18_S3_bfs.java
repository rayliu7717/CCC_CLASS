import java.io.*;
import java.util.*;

public class Main {
    static char[][] grid;
    static int[][] ans;
    static boolean[][] vis,cc;
    static Map<Character,int[]> dic;
    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    static int n,m,x0,y0;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();m= scanner.nextInt();
        grid = new char[n][m];
        ans = new int[n][m];
        vis = new boolean[n][m];
        cc = new boolean[n][m];
        dic = new HashMap<>();
        dic.put('R',dir[0]);
        dic.put('D',dir[1]);
        dic.put('U',dir[2]);
        dic.put('L',dir[3]);
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
        bfs(new int[]{x0,y0});
        for(int[] a:dest){
            System.out.println(vis[a[0]][a[1]]?ans[a[0]][a[1]]:-1);
        }
    }
    static void bfs(int[] start){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        if(grid[start[0]][start[1]]=='.' && !cc[start[0]][start[1]]){vis[start[0]][start[1]] = true;}
        else{return;}
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int[] nxt:dir){
                int x1 = x + nxt[0], y1= y+nxt[1];
                while ( inMoveRange(x1,y1) && dic.containsKey( grid[x1][y1]) ){
                    vis[x1][y1] = true;
                    int[] nxt1 = dic.get(grid[x1][y1]);
                    x1 +=  nxt1[0];
                    y1 += nxt1[1];
                    if(vis[x1][y1])
                        break;
                }
                if(inMoveRange(x1,y1)&& grid[x1][y1]!='W' && !cc[x1][y1] ){
                    if(!vis[x1][y1] ){
                        vis[x1][y1] = true;
                        ans[x1][y1] = ans[x][y]+1;
                        q.add(new int[]{x1,y1});
                    }
                }
            }
        }
    }
    static boolean inMoveRange(int x,int y){
        return x>0&&x<n-1&&y>0&&y<m-1;
    }
    static void markCC(int x,int y){
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
        grid[x][y] = '.';
        cc[x][y] = true;
    }
}