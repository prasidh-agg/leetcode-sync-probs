class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        long ans = 0;
        int picked = 0;

        for(int i = n - 1; i >= n - k; i--){
            int el = happiness[i] - picked;
            if(el <= 0) break;
            
            ans += el;
            picked++;


        }
        return ans;
    }
}
