class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        // Use primitive int array for speed
        int[] dp = new int[n];
        
        // Initialize with bottom row - cache the list reference
        List<Integer> lastRow = triangle.get(n - 1);
        for (int j = 0; j < n; j++) {
            dp[j] = lastRow.get(j);
        }
        
        // Bottom-up DP with optimizations
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);  // Cache list reference
            int rowSize = currentRow.size();             // Cache size
            
            for (int j = 0; j < rowSize; j++) {
                dp[j] = currentRow.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        
        return dp[0];
    }
}
