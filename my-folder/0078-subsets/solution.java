class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(0, nums, ds, ans);
        return ans;
    }
    private static void helper(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[index]);
        helper(index + 1, nums, ds, ans);
        ds.remove(ds.size() - 1);
        helper(index + 1, nums, ds, ans);
    }
}
