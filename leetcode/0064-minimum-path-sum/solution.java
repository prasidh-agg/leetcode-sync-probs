class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, - 1);
        }
        return helper(grid, m - 1, n - 1, dp);
    }
    public int helper(int[][] grid, int i, int j, int[][] dp){
        if(i == 0 && j == 0) return grid[i][j];

        if(i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != -1) return dp[i][j];

        int top = helper(grid, i - 1, j, dp);
        int down = helper(grid, i, j - 1, dp);
        return dp[i][j] = grid[i][j] + Math.min(top, down);
    }
}
