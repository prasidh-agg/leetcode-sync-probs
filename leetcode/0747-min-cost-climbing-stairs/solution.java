class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev2 = cost[0];
        int prev = cost[1];
        for(int i = 2; i < n; i++){
            int curr = cost[i] + Math.min(prev, prev2);
            prev2 = prev;
            prev = curr;
        }
        return Math.min(prev, prev2);
    }
}
