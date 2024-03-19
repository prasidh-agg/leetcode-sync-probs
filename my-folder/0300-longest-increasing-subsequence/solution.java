class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, nums, -1, dp);
    }
    public int solve(int index, int[] nums, int prev, int[][] dp){
        if(index == nums.length) return 0;

        if(prev != -1 && dp[index][prev] != -1) return dp[index][prev];

        int take = 0;
        if(prev == -1 || nums[prev] < nums[index]){
            take = 1 + solve(index + 1, nums, index, dp);
        }
        int notTake = solve(index + 1, nums, prev, dp);
        if(prev != -1){
            dp[index][prev] = Math.max(take, notTake);
        }
        return Math.max(take, notTake);
    }
}
