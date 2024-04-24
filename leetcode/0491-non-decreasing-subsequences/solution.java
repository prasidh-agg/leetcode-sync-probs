class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(res, curr, nums, 0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> curr, int[] nums, int idx){
        if(curr.size() >= 2){
            res.add(new ArrayList<>(curr));
        }

        Set<Integer> set = new HashSet<>();

        for(int i = idx; i < nums.length; i++){
            if((curr.isEmpty() || nums[i] >= curr.get(curr.size() - 1)) && !set.contains(nums[i])){
                curr.add(nums[i]); //include element
                backtrack(res, curr, nums, i + 1); //explore after including

                curr.remove(curr.size() - 1); //dont include element
                set.add(nums[i]);
            }
        }
    }
}
