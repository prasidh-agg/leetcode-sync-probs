class Solution {
    int MOD = 1000000007;
    int a = 0, e = 1, i = 2, o = 3, u = 4;
    public int countVowelPermutation(int n) {

        long[][] dp = new long[5][n + 1];
        for(int i = 0; i < 5; i++){
            Arrays.fill(dp[i], -1);
        }

        long result = 0;

        result = (result + solve(a, n-1, dp)) % MOD;
        result = (result + solve(e, n-1, dp)) % MOD;
        result = (result + solve(i, n-1, dp)) % MOD;
        result = (result + solve(o, n-1, dp)) % MOD;
        result = (result + solve(u, n-1, dp)) % MOD;
        return (int)result;
    }
    public long solve(int ch, int rem, long[][] dp){
        if(rem == 0){
            return 1;
        }
        if(dp[ch][rem] != -1) return dp[ch][rem];
        int res = 0;
        if(ch == a){
            return dp[ch][rem] = solve(e, rem - 1, dp) % MOD;
        }
        else if(ch == e){
            return dp[ch][rem] = (solve(a, rem - 1, dp) + solve(i, rem - 1, dp)) % MOD;
        }
        else if(ch == i){
            return dp[ch][rem] = (solve(a, rem - 1, dp) + solve(e, rem - 1, dp) + solve(o, rem - 1, dp) + solve(u, rem - 1, dp)) % MOD;
        }
        else if(ch == o){
            return dp[ch][rem] = (solve(i, rem - 1, dp) + solve(u, rem - 1, dp)) % MOD;
        }
        else{
            return dp[ch][rem] = solve(a, rem - 1, dp) % MOD;
        }
    }
}
