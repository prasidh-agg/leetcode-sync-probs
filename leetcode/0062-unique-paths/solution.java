class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return solve(m - 1, n - 1, dp);
    }
    public int solve(int row, int col, int[][] dp){
        //reached the end
        if(row == 0 && col == 0){
            return 1;
        }

        if(row < 0 || col < 0){
            return 0;
        }

        if(dp[row][col] != -1) return dp[row][col];

        int up = solve(row - 1, col, dp);

        int left = solve(row, col - 1, dp);

        return dp[row][col] = up + left;
    }
}
