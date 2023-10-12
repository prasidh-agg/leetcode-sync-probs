class Solution {
    public int maximumWealth(int[][] accounts) {
       int maxWealth = Integer.MIN_VALUE;
       int m = accounts.length;
       int n = accounts[0].length;
       for(int i = 0; i < m; i++){
           int currWealth = 0;
           for(int j = 0; j < n; j++){
               currWealth += accounts[i][j];
           }
           maxWealth = Math.max(currWealth, maxWealth);
       } 
        return maxWealth;
    }
}
