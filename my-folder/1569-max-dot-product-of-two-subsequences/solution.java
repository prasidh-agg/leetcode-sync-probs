class Solution {
    int m, n;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <=m; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, nums1, nums2, dp);
    }
    public int solve(int i, int j, int[] nums1, int[] nums2, int[][] dp){
        if(i == m || j == n){
            return -10000000;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int val = nums1[i] * nums2[j];
        int takeCurrOrNot = Math.max(val, val + solve(i + 1, j + 1, nums1, nums2, dp));
        int whichNextToTake = Math.max(solve(i, j + 1, nums1, nums2, dp), solve(i + 1, j, nums1, nums2, dp));

        return dp[i][j] = Math.max(takeCurrOrNot, whichNextToTake);  
    }
}
