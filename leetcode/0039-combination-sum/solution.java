class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private static void backtracking(int index, int[] nums, int target, List<Integer> workList, List<List<Integer>> result){
        if(index == nums.length){
            if(target == 0){
                result.add(new ArrayList<>(workList));
            }
            return;
        }
        if(nums[index] <= target){
            workList.add(nums[index]);
            backtracking(index, nums, target - nums[index], workList, result);
            workList.remove(workList.size() - 1);
        }
        backtracking(index + 1, nums, target, workList, result);
    }
}
