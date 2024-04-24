class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        List<Integer> res = new ArrayList<>();
        for(int num : nums1){
            arr[num]++;
        }

        for(int num : nums2){
            if(arr[num] > 0){
                arr[num]--;
                res.add(num);
            }
        }

        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
