import java.io.*;
import java.util.*;
public class CCC03S4 {
  public static void main(String[]args) throws IOException {
    Scanner in = new Scanner (System.in);
    int n = in.nextInt();
    String temp;
    
    for (int i = 0; i < n; i++) {
      temp = in.next();
      String[]a = new String[temp.length()];
      for (int x = 0; x < temp.length(); x++) {
        a[x] = temp.substring(x);
      }
      
      Arrays.sort(a);
      
      int result = 0;
      
      result = a[0].length();
      
      for (int x = 1; x < a.length; x++) {
        result += a[x].length() - lcp(a[x - 1], a[x]);
      }
      
      System.out.println(result + 1);
    }
  }
  
  public static int lcp(String a, String b) {
    int count = 0;
    if (a.length() <= b.length()) {
      for (int x = 0; x < a.length(); x++) {
        if (a.charAt(x) == b.charAt(x))
              count++;
        else
              return count;
      }
    }
    else {
      for (int x = 0; x < b.length(); x++) {
        if (a.charAt(x) == b.charAt(x))
              count++;
        else
              return count;
      }
    }
    return count;
  }
}