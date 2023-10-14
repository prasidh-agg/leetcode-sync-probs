class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(cost, time, 0, n, dp);
    }
    public int helper(int[] cost, int[] time, int index, int wallsRemaining, int[][] dp){
        if(wallsRemaining <= 0) return 0;
        if(index == cost.length) return (int)1e9;

        if(dp[index][wallsRemaining] != -1) return dp[index][wallsRemaining];

        int paint = cost[index] + helper(cost, time, index + 1, wallsRemaining - 1 - time[index], dp);
        int notPaint = helper(cost, time, index + 1, wallsRemaining, dp);
        
        return dp[index][wallsRemaining] = Math.min(paint, notPaint);
    }
}
