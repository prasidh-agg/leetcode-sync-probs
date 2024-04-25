class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lo = 0, hi = n - 1;
        int lmax = 0, rmax = 0, ans = 0;
        while(lo < hi){
            if(height[lo] > lmax) lmax = height[lo];
            if(height[hi] > rmax) rmax = height[hi];
            if(lmax < rmax){
                //calc water at lo
                ans += lmax - height[lo];
                lo++;
            }
            else{
                //calc water at hi
                ans += rmax - height[hi];
                hi--;
            }
        }
        return ans;
    }
}
