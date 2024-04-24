class Solution {
    public int[] sortArrayByParity(int[] nums) {

        int n = nums.length;
        int l = 0, r = n - 1;
        int[] res = new int[n];

        for(int num : nums){
            if(num % 2 == 0) res[l++] = num;
            else res[r--] = num;
        }
        return res;
    }
}
