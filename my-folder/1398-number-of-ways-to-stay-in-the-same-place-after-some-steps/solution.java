class Solution {
    private int MOD = 1000000007;
    public int numWays(int steps, int arrLen) {
        int[][] dp = new int[steps + 1][steps + 1];
        for(int i = 0; i <= steps; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return helper(steps, arrLen, 0, dp);
    }
    private int helper(int steps, int arrLen, int index, int[][] dp){
        if(index < 0 || index == arrLen) return 0;
        if (steps == 0) {
            return (index == 0) ? 1 : 0;
        }

        if(dp[steps][index] != -1){
            return dp[steps][index];
        }
        long ways = 0; 
        ways += helper(steps - 1, arrLen, index - 1, dp) % MOD;
        ways += helper(steps - 1, arrLen, index, dp) % MOD;
        ways += helper(steps - 1, arrLen, index + 1, dp) % MOD;

        return dp[steps][index] = (int)((ways) % MOD);
    }
}
