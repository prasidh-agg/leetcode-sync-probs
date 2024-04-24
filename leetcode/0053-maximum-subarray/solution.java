class Solution {
    public int maxSubArray(int[] nums) {
        int currMax = 0, maxTillNow = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            currMax = Math.max(nums[i], nums[i] + currMax);
            maxTillNow = Math.max(currMax, maxTillNow);
        }
        return maxTillNow; 
    }
}
