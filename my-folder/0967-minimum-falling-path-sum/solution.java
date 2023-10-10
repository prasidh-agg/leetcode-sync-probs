class Solution {
    public int minFallingPathSum(int[][] matrix){
        int n = matrix.length;
        int[] prev = new int[n];
        int[] curr = new int[n];
        //Base case
        for(int i = 0; i < n; i++) prev[i] = matrix[0][i];
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                int val = matrix[i][j];
                int top = val + prev[j];

                int right = val;
                if(j < n - 1) right += prev[j+1];
                else right += 1000001;

                int left = val;
                if(j >= 1) left += prev[j-1];
                else left += 1000001;

                curr[j] = Math.min(left, Math.min(top, right));
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        int ans = 1000001;
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, prev[i]);
        }
        return ans;
    }
}
