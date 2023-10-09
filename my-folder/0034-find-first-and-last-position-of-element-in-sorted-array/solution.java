class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = leftBinarySearch(nums, target, -1);
        int second = rightBinarySearch(nums, target, -1);
        return new int[]{first, second};
    }

    private static int leftBinarySearch(int[] nums, int target, int index){
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                index = mid;
                r = mid - 1; // search the left half to look for the first index
            }
            else if(nums[mid] < target){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return index;
    }
    private static int rightBinarySearch(int[] nums, int target, int index){
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                index = mid;
                l = mid + 1; // search the right half to look for the last index
            }
            else if(nums[mid] < target){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return index;
    }
}
