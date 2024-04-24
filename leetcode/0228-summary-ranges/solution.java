class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> ans = new ArrayList<>();
        int n = nums.length;

        if(n == 0) return ans;
        int start = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(i == n - 1 || nums[i]+1 != nums[i+1]){
                if(nums[i] != start){
                    ans.add(start + "->" + nums[i]);
                }
                else{
                    ans.add(start + "");
                }
                if(i != n - 1){
                    start = nums[i+1];
                }
            }
        }
        return ans;

    }
}
