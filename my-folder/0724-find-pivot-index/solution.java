class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sumLeft = new int[n];
        int[] sumRight = new int[n];
        int leftSum = 0, rightSum = 0;

        for(int i = 0; i < n; i++){
            leftSum += nums[i];
            sumLeft[i] = leftSum;
        }
        for(int i = n - 1; i >= 0; i--){
            rightSum += nums[i];
            sumRight[i] = rightSum;
        }
        
        for(int i = 0; i < n; i++){
            if(sumLeft[i] == sumRight[i]) return i;
        }
        return -1;
    }
}
