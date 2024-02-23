class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
// a number n has the same 1 bits as it has when divided by 2(right shifting 1 bit)..
// we also need to add the last bit, because if the number is odd then that 1 bit will be lost
