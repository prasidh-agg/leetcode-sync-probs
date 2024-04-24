class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] newArr = new int[n];
        int pos = 0, neg = 1;
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                newArr[pos] = nums[i];
                pos += 2;
            }
            else{
                newArr[neg] = nums[i];
                neg += 2;
            }
        }
        return newArr;
    }
}
