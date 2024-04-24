class Solution {
    public int arraySign(int[] nums) {
       int ans = 1;
       for(int num : nums){
           if(num < 0) ans = -ans;
           if(num == 0) return 0;
       }
       return ans; 
    }
}
