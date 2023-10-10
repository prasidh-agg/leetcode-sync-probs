class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = n;

        // Sort the array
        Arrays.sort(nums);

        // Remove duplicates to only keep unique elements
        int idx = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[idx] = nums[i];
                idx++;
            }
        }

        //used to calc upper bound
        int j = 0;
        for(int i = 0; i < idx; i++){
            while(j < idx && nums[j] < nums[i] + n){
                j++;
            }
            int count = j - i;
            ans = Math.min(ans, n - count);
        }
        return ans;  
    }
}
