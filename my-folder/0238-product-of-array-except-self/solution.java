class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int prePostFix = 1;
        for(int i = 0; i < nums.length; i++){
            result[i] = prePostFix;
            prePostFix *= nums[i];
        }

        prePostFix = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            result[i] *= prePostFix;
            prePostFix *= nums[i];
        }
        return result;
    }
}
