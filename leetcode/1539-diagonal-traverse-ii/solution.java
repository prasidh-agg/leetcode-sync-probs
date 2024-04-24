class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size();
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = n - 1; i >= 0; i--){
            int m = nums.get(i).size();
            for(int j = 0; j < m; j++){
                int sum = i + j;
                if(!map.containsKey(sum)){
                    map.put(sum, new ArrayList<Integer>());
                }
                map.get(sum).add(nums.get(i).get(j));
                count++;
            }
        }

        int diagonal = 0;
        int[] result = new int[count];
        int i = 0;

        while(map.containsKey(diagonal)){
           for(int num : map.get(diagonal)){
               result[i++] = num;
           }
           diagonal++; 
        }

        return result;
    }
}
