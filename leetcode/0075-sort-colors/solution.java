class Solution {
    public void sortColors(int[] nums) {
        int zeroPointer = 0, twoPointer = nums.length - 1, index = 0;
        while(index <= twoPointer){
            if(nums[index] == 0){
                swap(nums, zeroPointer, index);
                zeroPointer++;
                index++;
            }
            else if(nums[index] == 2){
                swap(nums, twoPointer, index);
                twoPointer--;
            }
            else{
                index++;
            }
        }
    }
    public void swap(int[] nums, int n1, int n2){
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }
}

