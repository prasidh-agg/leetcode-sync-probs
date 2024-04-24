class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> set = new HashSet<>();

       for(int num: nums){
           set.add(num);
       }
       int maxCount = 0;
       for(int curr : nums){
            int count = 1;

            //this means we will reach the sequence from the upper end
            if(set.contains(curr + 1)) continue;

            while(set.contains(--curr)){
                count++;
            }
            maxCount = Math.max(count, maxCount);
       }
       return maxCount;
    }
}
