class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++){

            // because the array is sorted, if two adj elements are equal, we skip
            // the second one because we have already found the answer for the first
            // one
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            // because the array is sorted, if the first fixed number is positive, 
            // there is no way we can find a negative going forward so that the sum
            // negates to 0.
            if(nums[i] > 0) return result;

            int diff = -nums[i], lo = i + 1, high = nums.length - 1;
            while(lo < high){
                if(nums[lo] + nums[high] == diff){
                    List<Integer> trip = Arrays.asList(nums[i], nums[lo], nums[high]);
                    result.add(trip);

                    //take care of duplicates
                    while(lo < high && nums[lo] == nums[lo + 1]) lo++;
                    while(lo < high && nums[high] == nums[high - 1]) high--;

                    lo++;
                    high--;
                }
                else if(nums[lo] + nums[high] > diff) high--;
                else lo++;
            }
        }
        return result;
    }
}
