class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] count = new int[map.size()];
        int index = 0;
        for(int val : map.values()){
            count[index++] = val;
        }

        Arrays.sort(count);

        for(int i = 0; i < count.length; i++){
            k -= count[i];
            if(k > 0) continue;
            else if(k == 0){
                return count.length - i - 1;
            }
            else{
                return count.length - i;
            }
        }
        return 0;
    }
}


