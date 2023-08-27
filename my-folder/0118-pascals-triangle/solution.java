class Solution {
    public List<List<Integer>> generate(int numRows) {
        // first and last always 1
        // rest every element 'i' is sum of previous rows 2 elements 'i', 'i+1'

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = null;

        for(int i = 0; i < numRows; i++){
            List<Integer> curr = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    curr.add(1);
                }
                else{
                    curr.add(prev.get(j-1) + prev.get(j));
                }
                
            }
            prev = curr;
            res.add(curr);
        }
        return res;
    }
}
