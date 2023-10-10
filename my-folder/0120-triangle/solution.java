class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(0, 0, triangle, dp);

    }
    public int helper(int i, int j, List<List<Integer>> triangle, int[][] dp){
        if(i == triangle.size() - 1) return triangle.get(i).get(j);

        if(dp[i][j] != -1) return dp[i][j];

        int sameIdx = helper(i + 1, j, triangle, dp);
        int nextIdx = helper(i + 1, j + 1, triangle, dp);
        
        return dp[i][j] = Math.min(sameIdx, nextIdx) + triangle.get(i).get(j);
    }
}
