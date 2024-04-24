class Solution {
    public int deleteAndEarn(int[] nums) {

        if(nums.length == 1) return nums[0];
        int max = 0;

        //get the max of array so that we know what size count array to make
        for(int num : nums){
            max = Math.max(max, num);
        }

        // + 1 so that if max is 4, we can have index 4 as well (by making length 5)
        int[] count = new int[max + 1];

        //now build the count array
        for(int num : nums){
            count[num] += num;
        }

        //now we have the final array, perform house robber problem on it starting from index 2.. 
        //because index 0 will have 0 only..

        int prev = 0, prev2 = 0;
        for(int i = 1; i < count.length; i++){
            // max of not take case, and take case
            int curr = Math.max(prev, prev2 + count[i]);
            prev2 = prev;
            prev = curr;

        }
        return prev;
    }
    
}
