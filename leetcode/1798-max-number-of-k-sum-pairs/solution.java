class Solution {
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);

        int l = 0, r = nums.length - 1;
        while(l < r){
            if(nums[l] + nums[r] > k){
                r--;
            }
            else if(nums[l] + nums[r] < k){
                l++;
            }
            else{
                l++; r--;
                ans++;
            }
        }
        return ans;
    }
}
