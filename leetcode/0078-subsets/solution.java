class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> subset, int[] nums, int index){

        //base case
        if(index == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        //add
        subset.add(nums[index]);
        backtrack(ans, subset, nums, index + 1);

        //remove what we added
        subset.remove(subset.size() - 1);
        backtrack(ans, subset, nums, index + 1);

    }
}
