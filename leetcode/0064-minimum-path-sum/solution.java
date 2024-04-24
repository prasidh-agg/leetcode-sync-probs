class Solution {
    public int minPathSum(int[][] grid) {
       int m = grid.length, n = grid[0].length;
       int[][] dp = new int[m][n];
       for(int i = 0; i < m; i++){
           Arrays.fill(dp[i], -1);
       }
       return helper(m - 1, n - 1, grid, dp); 
    }
    private int helper(int i, int j, int[][] grid, int[][] dp){
        //reached top left
        if(i == 0 && j == 0) return grid[i][j];

        //invalid path
        if(i < 0 || j < 0) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        int up = helper(i - 1, j, grid, dp);
        int left = helper(i, j - 1, grid, dp);

        return dp[i][j] = Math.min(up, left) + grid[i][j];
    }
}
