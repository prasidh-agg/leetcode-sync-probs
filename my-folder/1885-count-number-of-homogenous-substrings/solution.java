class Solution {
    public int countHomogenous(String s) {
        int MOD = 1000000007;
        long res = 0;
        char[] c = s.toCharArray();
        int l = 0;
        for (int r = 0; r < c.length; r++) {
            if (c[r] != c[l]) {
                res += ((long) (r - l) * (r - l + 1) / 2) % MOD; // Use long to prevent overflow
                res %= MOD; // Take modulo at each step to prevent overflow
                l = r;
            }
        }

        res += ((long) (c.length - l) * (c.length - l + 1) / 2) % MOD;
        res %= MOD;

        return (int) res;
    }
}

