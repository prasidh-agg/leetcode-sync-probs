class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] res = new int[n/3][3];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i += 3){
            if(nums[i + 2] - nums[i] > k){
                return new int[][]{};
            }
        }
        int count = 0;
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < 3; j++){
                res[i][j] = nums[count++];
            }
        }

        return res;
    }
}
