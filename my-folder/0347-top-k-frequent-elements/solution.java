class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // if(nums.length == k) return nums;

        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        int[] result = new int[k];
        int counter = 0;
        for(int i = buckets.length - 1; i > 0; i--){
            if(buckets[i] == null) continue;
            for(int curr : buckets[i]){
                result[counter++] = curr;
                if(counter == k) return result;
            }
        }
        return result;
    }
}
