class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for(Integer occurence : map.values()){
            if(!set.add(occurence)) return false;
        }
        return true;
    }
}
