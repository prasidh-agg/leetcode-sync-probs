class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int len = nums.length;
		
        for(int i = n; i < len; i++) {
            nums[i] = (nums[i] * 1001) + nums[i - n];
        }
        
        int index = 0;

        for(int i = n; i < len; i++, index += 2) {
            nums[index] = nums[i] % 1001;
            nums[index + 1] = nums[i] / 1001;
        }
        
        return nums;
    }
}

