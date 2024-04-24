class Solution {
    public int[] sortedSquares(int[] nums) {

        int l = 0, r = nums.length - 1;
        int[] res = new int[nums.length];
        int counter = nums.length - 1;
        while(l <= r){
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                res[counter--] = nums[l] * nums[l];
                l++;
            }
            else{
                res[counter--] =nums[r] * nums[r];
                r--;
            }
        }
        return res;
    }
}
