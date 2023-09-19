class Solution {
    public int findDuplicate(int[] nums) {

        //Using extra space
        boolean[] k = new boolean[nums.length+1];
        for(int i = 0;i<nums.length;i++){
            if(k[nums[i]])return nums[i];
            else k[nums[i]] = true;
        }
        return -1;
    }

        // //Without any extra space and without modifying the array nums
        // int slow = nums[0];
        // int fast = nums[0];

        // do{
        //     slow = nums[slow];
        //     fast = nums[nums[fast]];
        // }while(slow != fast);

        // slow = nums[0];
        // while(slow != fast){
        //     slow = nums[slow];
        //     fast = nums[fast];
        // }
        // System.gc();
        // return slow;
    // }
}
