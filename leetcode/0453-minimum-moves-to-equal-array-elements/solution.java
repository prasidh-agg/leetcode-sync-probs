class Solution {
    public int minMoves(int[] nums) {
        if(nums.length == 1) return 0;
        
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            min = Math.min(num, min);
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++){
            count += nums[i] - min;
        }

        return count;
    }
}
