class Solution {
    public int minOperations(int[] nums, int x) {

        int totalSum = 0;
        for(int n : nums) totalSum += n;

        if (totalSum < x)
            return -1;
        
        if (totalSum == x)
            return nums.length;

        int targetSum = totalSum - x;
        int maxLen = -1;
        int currSum = 0;

        for(int l = 0, r = 0; r < nums.length; r++){
            currSum += nums[r];
            while(l <= r && currSum > targetSum) currSum -= nums[l++];
            if(currSum == targetSum) maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
        
    }
}
