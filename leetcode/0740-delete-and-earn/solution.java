class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = 0;

        for(int num : nums){
            max = Math.max(num, max);
        }

        int[] count = new int[max + 1];
        for(int num : nums){
            count[num] += num;
        }

        //House robber code
        int prev2 = 0, prev = 0;
        for(int i = 1; i < count.length; i++){
            int curr = Math.max(prev2 + count[i], prev);
            prev2 = prev;
            prev = curr;
        }
        return prev;

    }
}
