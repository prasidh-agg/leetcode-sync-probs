class Solution {
       public int findTheWinner(int n, int k) {
     
        List<Integer> ans=new ArrayList<>();
        for(int i = 1; i <= n; i++){
            ans.add(i);
        }

        int cur = 0;
        while(ans.size() > 1){
            cur=(cur + k -1 ) % ans.size();
            ans.remove(cur);
        }
        return ans.get(0);
    }
}
