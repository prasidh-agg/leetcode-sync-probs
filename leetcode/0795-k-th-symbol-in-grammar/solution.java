class Solution {
    public int kthGrammar(int n, int k) {
        return dfs(n, k, 0);
    }
    public int dfs(int n, int k, int rootVal){
        if(n == 1){
            return rootVal;
        }
        int totalNodes = (int)Math.pow(2, n - 1);
        //right tree
        if( k > totalNodes / 2){
            int nextRootVal = (rootVal == 0) ? 1 : 0;
            return dfs(n - 1, k - (totalNodes/2), nextRootVal);
        }
        //left tree
        else{
            int nextRootVal = (rootVal == 0) ? 0 : 1;
            return dfs(n - 1, k, nextRootVal);
        }
    }
}
