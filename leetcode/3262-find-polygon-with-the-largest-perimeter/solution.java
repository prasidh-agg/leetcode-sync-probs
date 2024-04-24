class Solution {
    public long largestPerimeter(int[] nums) {
       long per = -1;
       Arrays.sort(nums);

       // create the prefix sum array
       long[] prefix = new long[nums.length];
       long sum = 0;
       for(int i = 0; i < nums.length; i++){
           prefix[i] = sum + nums[i];
           sum += nums[i];
       }

       // take minimum 3 elements, so start from index 2..

       for(int i = 2; i < nums.length; i++){
           if(nums[i] < prefix[i - 1]){
               //its possible to create a polygon
               per = Math.max(prefix[i - 1] + nums[i], per);

           }
       }
       return per;
    }
}

