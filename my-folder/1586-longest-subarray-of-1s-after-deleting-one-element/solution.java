class Solution {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0, longestWindow = 0, left = 0;
        for(int right = 0; right < nums.length; right++){
            zeroCount += nums[right] == 0 ? 1 : 0;
            while(zeroCount > 1){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            longestWindow = Math.max(longestWindow, right - left);
        }
        return longestWindow;
    }
}
