import java.io.*;
import java.util.*;
public class CCC_04_03 {
    /**
     * CCC '04 S3 - Spreadsheet
     */
    static String[][] grid = new String[10][9];
    static boolean[][] vis;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            String [] cols = scanner.nextLine().split(" ");
            for (int j = 0; j < 9; j++) {
                grid[i][j] = cols[j];
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                vis = new boolean[10][9];
                dfs(i, j);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int dfs(int r, int c) {
        if (isNumeric(grid[r][c])) return Integer.parseInt(grid[r][c]);
        if (vis[r][c] || grid[r][c].equals("*")) return -1;
        vis[r][c] = true;
        String [] depend = grid[r][c].split("\\+");
        int sum = 0;
        for (int i = 0; i < depend.length; i++) {
            int ret = dfs(depend[i].charAt(0)-'A', depend[i].charAt(1)-'1');
            if (ret==-1) {
                grid[r][c] = "*";
                return -1;
            }
            else sum+=ret;
        }
        grid[r][c] = String.valueOf(sum);
        return sum;
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}