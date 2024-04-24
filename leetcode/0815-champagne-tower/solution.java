class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[101];
        dp[0] = poured;
        for(int i = 0; i < query_row; i++){
            double[] next = new double[101];
            for(int j = 0; j <= i; j++){
                double excess = (dp[j] - 1)/2;
                if(excess > 0){
                    next[j] += excess;
                    next[j + 1] += excess;
                }
            }
            dp = next;
        }
        return Math.min(1.0, dp[query_glass]);
    }
}
