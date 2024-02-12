class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[501];
        Arrays.fill(dp, -1);
        return solve(0, arr, k, dp);
    }
    public int solve(int index, int[] arr, int k, int[] dp){
        if(index >= arr.length) return 0;
        if(dp[index] != -1) return dp[index];
        int result = 0;
        int currMax = -1;
        for(int j = index; j < arr.length && j - index + 1 <= k; j++){
            currMax = Math.max(currMax, arr[j]);
            result = Math.max(result, (j - index + 1) * currMax + solve(j + 1, arr, k, dp));
        }

        return dp[index] = result;
    }
}
