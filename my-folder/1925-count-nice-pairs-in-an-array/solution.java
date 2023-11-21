class Solution {
    private int MOD = 1000000007;
    public int countNicePairs(int[] nums) {
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            //adding MOD in case of negative result from the subtraction
            nums[i] = (nums[i] - reverse(nums[i]) + MOD) % MOD;
            count = (count + map.getOrDefault(nums[i], 0)) % MOD;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }

        return count;
    }
    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
