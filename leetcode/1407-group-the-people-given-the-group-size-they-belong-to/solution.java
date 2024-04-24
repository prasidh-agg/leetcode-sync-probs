class Solution {
    public List<List<Integer>> groupThePeople(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], new ArrayList<>());
            }
            List<Integer> currList = map.get(arr[i]);
            currList.add(i);
            if(currList.size() == arr[i]){
                result.add(currList);
                map.remove(arr[i]);
            }
        }
        return result;
    }
}
