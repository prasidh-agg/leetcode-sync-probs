class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int choice1 = robHelper(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int choice2 = robHelper(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(choice1, choice2);        
    }
    public int robHelper(int[] nums){
        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i < nums.length; i++){
            int pick = nums[i];
            if(i > 1) pick += prev2;

            int notPick = prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
