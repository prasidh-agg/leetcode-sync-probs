class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        for(int i = 0; i < n; i++){
            //primary diagonal
            sum += mat[i][i];

            //secondary diagonal
            sum += mat[n-1-i][i];

        }
        if(n % 2 != 0){
            sum -= mat[n/2][n/2];
        }
        return sum;
    }
}
