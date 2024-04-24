class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int i = k, j = k;
        int currMin = nums[k];
        int res = currMin;
        while(i > 0 || j < n - 1){
            int leftVal = (i > 0) ? nums[i-1] : 0;
            int rightVal = (j < n -1) ? nums[j+1] : 0;
            if(leftVal > rightVal){
                i -= 1;
                currMin = Math.min(currMin, leftVal);
            }
            else{
                j += 1;
                currMin = Math.min(currMin, rightVal);
            }
            res = Math.max(res, currMin * (j - i + 1));
        }
        return res;
    }
}
