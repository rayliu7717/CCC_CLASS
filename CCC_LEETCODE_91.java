public class CCC_leetcode_91 {
    public static void main(String[] args) {

        String s = "11111";
        char[] chs = s.toCharArray();
        int res = decodeWays(chs, 0);
        System.out.println(res);
        res = dp_decodeWays(s);
        System.out.println(res);
    }
    // all positions before i already confirmed, we can ignore
    // i...  how many decode ways
    static int decodeWays(char[] str, int i)
    {
        if(i == str.length)
            return 1;
        // i not to end
        if(str[i] == '0')
            return 0;
        if (str[i] == '1') {
            int res = decodeWays(str, i+1);  // '1' to A
            if(i+1 < str.length)
                res += decodeWays(str,i+2); // (i and i+1) to decode one character
            return res;
        }
        if(str[i] == '2'){
            int res = decodeWays(str, i+1); // '2' to B
            if(i+1 < str.length && str[i+1] >='0' && str[i+1] <='6')
                res+= decodeWays(str, i+2);
            return res;
        }
        //'3' to '9'
        return decodeWays(str,i+1);
    }
    static int dp_decodeWays(String s){
        if(s == null || s.isEmpty()) return 0;
        char str[] = s.toCharArray();
        int n = str.length;
        int [] dp = new int[n+1];
        dp[n] = 1;
        for(int i = n -1; i>= 0 ;i--){
            // dp[i] = ?
            if(str[i] == '0')
                dp[i] =  0;
            else if (str[i] == '1') {
                dp[i]= dp[i+1];
                if(i+1 < str.length)
                    dp[i] += dp[i+2]; // (i and i+1) to decode one character
            }
            else if(str[i] == '2'){
                dp[i] = dp[i+1]; // '2' to B
                if(i+1 < str.length && str[i+1] >='0' && str[i+1] <='6')
                    dp[i] += dp[i+2];
            }
            else
                dp[i] = dp[i+1];
        }
        return dp[0];
    }
}