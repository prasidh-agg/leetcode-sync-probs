class Solution {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0, longestWindow = 0, start = 0;
        for(int i = 0; i < nums.length; i++){
            zeroCount += nums[i] == 0 ? 1 : 0;
            while(zeroCount > 1){
                if(nums[start] == 0){
                    zeroCount--;
                }
                start++;
            }
            longestWindow = Math.max(longestWindow, i - start);
        }
        return longestWindow;
    }
}
