class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){

            //skip duplicates
            if( i > 0 && nums[i] == nums[i - 1]) continue;

            int n1 = nums[i];

            //if curr number is positive, numbers after it will also be positive, cant make 0
            if(n1 > 0) break;

            int target = -1 * n1;
            int l = i + 1, r = nums.length - 1;
            while(l < r){
                if(nums[l] + nums[r] > target) r--;
                else if(nums[l] + nums[r] < target) l++;
                else{
                    while(l < r && nums[l] == nums[l + 1])l++;
                    while(l < r && nums[r] == nums[r - 1])r--;
                    result.add(new ArrayList<>(Arrays.asList(n1, nums[l++], nums[r--])));
                }
            }

        }
        return result;
    }
}
