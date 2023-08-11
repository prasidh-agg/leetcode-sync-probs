class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String hash = String.valueOf(arr);
            if (!map.containsKey(hash)) map.put(hash, new ArrayList<>());
            map.get(hash).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
