class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int ans = 0;
        for(int num : nums){
            count[num]++; 
        }
        for(int num : count){
            if(num > 1){
                ans += num * (num - 1)/2;
            }
        }
        return ans;
    }
}
