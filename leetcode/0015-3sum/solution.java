class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n - 2; i++){

            if(i > 0 && nums[i] == nums[i - 1]) continue;

            if(nums[i] > 0) break;

            int target = -1 * nums[i];
            int l = i + 1, r = n - 1;
            while(l < r){
                if(nums[l] + nums[r] < target) l++;

                else if(nums[l] + nums[r] > target) r--;
                else{
                    while(l < r && nums[l] == nums[l + 1]) l++;
                    while(l < r && nums[r] == nums[r - 1]) r--;
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[l++], nums[r--])));
                }
            }
            
        }
        return result;
    }
}
