class Solution {
    public int maxCoins(int[] nums) {
        final int n = nums.length;
        int[] vals = new int[n + 2];
        for (int i = 0; i < n; ++i) vals[i + 1] = nums[i];
        vals[0] = vals[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int l = 1; l <= n; ++l){
            for (int i = 1; i + l <= n + 1; ++i) {
                int j = i + l - 1;
                int best = 0;
                for (int k = i; k <= j; ++k){
                    best = Math.max(best, 
                        dp[i][k - 1] + vals[i - 1] * vals[k] * vals[j + 1] + dp[k + 1][j]);
                }
                dp[i][j] = best;
            }
        }
        return dp[1][n];        
    }
}