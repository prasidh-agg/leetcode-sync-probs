class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        long sum1 = 0, sum2 = 0;
        int j = 0, k = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0) even.add(nums[i]);
            else odd.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            if(target[i] % 2 == 0){
                sum1 += Math.abs(even.get(j++) - target[i]);
            }
            else{
                sum2 += Math.abs(odd.get(k++) - target[i]);
            }
        }
            
        sum1 /= 2;
        sum2 /= 2;

        return (sum1 + sum2) / 2;

    }
}
