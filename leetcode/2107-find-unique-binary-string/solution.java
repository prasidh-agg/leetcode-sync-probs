class Solution {
    public String findDifferentBinaryString(String[] nums) {
        String res = new String();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            // if(nums[i].charAt(i) == '0'){
            //     res += "1";
            // }
            // else res += "0";
            res += nums[i].charAt(i) == '0' ? "1" : "0";
        }
        return res;
    }
}
