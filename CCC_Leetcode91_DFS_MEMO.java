class Solution {
    
    public int numDecodings(String s) {
        char[] chs = s.toCharArray();
        int[] memo = new int[chs.length + 1];
        int res = decodeWays(chs, 0, memo);
        //System.out.println(res); 
        return res;       
    }

    // all positions before i already confirmed, we can ignore
    // i...  how many decode ways
    static int decodeWays(char[] str, int i, int[] memo)
    {
        if(i == str.length){
            memo[i] = 1;
            return 1;
        }
        // i not to end
        if(str[i] == '0'){
            memo[i] = 0;
            return 0;
        }
        if(memo[i] > 0) return memo[i];
        if (str[i] == '1') {
            int res = decodeWays(str, i+1,memo);  // '1' to A
            if(i+1 < str.length)
                res += decodeWays(str,i+2,memo); // (i and i+1) to decode one character
            memo[i] = res;
            return res;
        }
        if(str[i] == '2'){
            int res = decodeWays(str, i+1,memo); // '2' to B
            if(i+1 < str.length && str[i+1] >='0' && str[i+1] <='6')
                res+= decodeWays(str, i+2,memo);
            memo[i] = res;
            return res;
        }

        //'3' to '9'
        memo[i] = decodeWays(str,i+1,memo);;
        //return decodeWays(str,i+1);
        return memo[i];
    }

}