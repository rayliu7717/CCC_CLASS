import java.io.*;
import java.util.*;
public class CCC_12S4 {
    static int n;
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        for(n = scanner.nextInt(); n != 0; n = scanner.nextInt()) {
            String start = "";
            String end = "";
            for(int i=1; i<=n; i++) {
                if(i>1) {
                    start += " ";
                    end += " ";
                }
                start += scanner.next();
                end += Integer.toString(i);
            }
            int ans = bfs(start, end);
            System.out.println(ans == -1? "IMPOSSIBLE": ans);
        }
    }
    static int bfs(String start, String end ) {
        HashSet<String> vis = new HashSet<>();
        int step = 0;
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int sz = q.size();
            for (int k= 0;k<sz; ++k) {
                String u = q.poll();
                if(u.compareToIgnoreCase(end) == 0) return step;
                String[] s = u.split(" ");
                for(int i = 0;i < s.length  ; ++i){
                    // move i to i -1
                    if(i> 0 && s[i - 1].charAt(0) > s[i].charAt(0) )
                        move(s.clone(), i, i-1, vis, q);
                    // move i  to i + 1
                    if( i< s.length -1 && s[i + 1].charAt(0) > s[i].charAt(0) )
                        move(s.clone(), i, i+1, vis, q);
                }
            }
            step ++;
        }
        return -1;
    }
    
    static public void move(String [] s, int from, int to,HashSet<String> vis, Queue<String> q )
    {
        if(s[to].charAt(0) == '9')
            s[to] = "";
        s[to] = s[from].charAt(0) + s[to];
        s[from] = s[from].substring(1);
        if(s[from].isEmpty()) s[from] = "9";
        String newStart = String.join(" ", s);
        if(!vis.contains(newStart)) {
            vis.add(newStart);
            q.add(newStart);
        }
    }

}