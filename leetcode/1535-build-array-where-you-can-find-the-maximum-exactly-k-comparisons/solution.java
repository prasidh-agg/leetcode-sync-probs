class Solution {
    int[][][] cache;
    int MOD = (int)1e9 + 7;
    int n;
    int m;
    public int numOfArrays(int n, int m, int k) {
        cache = new int[n][m+1][k+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= m; j++){
                Arrays.fill(cache[i][j], -1);
            }
        }
        this.m = m;
        this.n = n;
        return dp(0,0,k);
    }
    public int dp(int i, int maxSoFar, int remain){
        if(i == n){
            return remain == 0 ? 1 : 0;
        }
        if(remain < 0) return 0;
        if(cache[i][maxSoFar][remain] != -1){
            return cache[i][maxSoFar][remain];
        }
        int count = 0;
        for(int num = 1; num <= maxSoFar; num++){
            count = (count + dp(i+1, maxSoFar, remain)) % MOD;
        }
        for(int num = maxSoFar + 1; num <= m; num++){
            count = (count + dp(i + 1, num, remain - 1)) % MOD;
        }
        cache[i][maxSoFar][remain] = count;
        return count;
    }
}
