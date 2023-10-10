class Solution {
    public int uniquePaths(int m, int n) {

        int[] prev = new int[m];

        for(int i = 0; i < m; i++){
            int[] currRow = new int[n];

            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) currRow[j] = 1;
                else{
                    int up = 0, left = 0;
                    if(i > 0) up = prev[j];
                    if(j > 0) left = currRow[j-1];
                    currRow[j] = up + left;
                }
            }
            prev = currRow.clone();
        }
        return prev[n-1];
    }
    
}
