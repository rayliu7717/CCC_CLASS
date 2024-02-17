import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int club = scanner.nextInt();
        int [] coins = new int[club];
        for (int i = 0; i < club; ++i){
            coins[i] = scanner.nextInt();
        }

        int [] dp =  new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=1;i<=amount; ++i){
            for(int j = 0;j<coins.length; ++j){
                if(coins[j] <= i)
                dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
            }
        }
        if(dp[amount]>amount) 
            System.out.println("Roberta acknowledges defeat.");
        else 
            System.out.println("Roberta wins in " +  dp[amount] +  " strokes.");
    }
    
}