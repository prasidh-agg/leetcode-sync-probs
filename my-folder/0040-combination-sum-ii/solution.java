class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(0, candidates, target, new ArrayList<>(), result);
        return result;
    }
    private static void backtracking(int index, int[] nums, int target, List<Integer> workList, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(workList));
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) break;

            workList.add(nums[i]);
            backtracking(i + 1, nums, target - nums[i], workList, result);
            workList.remove(workList.size() - 1);
        }
    }
}
