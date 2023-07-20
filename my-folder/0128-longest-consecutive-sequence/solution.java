class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        } 

        int maxCount = 0;
        for(int curr : nums){
            int count = 1;
            if(set.contains(curr + 1)) continue;

            while(set.contains(--curr)){
                count++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
