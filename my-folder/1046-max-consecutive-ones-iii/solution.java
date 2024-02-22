class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, maxOnes = 0, zeroCount = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0) zeroCount++;
            
            //Shrink the window from left because we have way too many zeroes in our current window
            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }

            maxOnes = Math.max(maxOnes, right - left + 1);
        }

        return maxOnes;
    }
}
