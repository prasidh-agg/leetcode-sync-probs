class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cand1 = 0, cand2 = 0, count1 = 0, count2 = 0, n = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int num : nums){
            if(num == cand1){
                count1++;
            }
            else if(num == cand2){
                count2++;
            }
            else if(count1 == 0){
                cand1 = num;
                count1 = 1;
            }
            else if(count2 == 0){
                cand2 = num;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(num == cand1) count1++;
            else if(num == cand2) count2++;
            else continue;
        }
        if(count1 > n/3) res.add(cand1);
        if(count2 > n/3) res.add(cand2);
        return res;
    }
}
