class Solution {

    private static void recurHelper(int index, int[] nums, List<List<Integer>> ans){
        if(index == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index; i < nums.length; i++){
            swap(i, index, nums);
            recurHelper(index + 1, nums, ans);
            swap(i, index, nums);
        }
       
    }
    private static void swap(int idx1, int idx2, int[] nums){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        recurHelper(0, nums, ans);
        return ans;

    }
}
