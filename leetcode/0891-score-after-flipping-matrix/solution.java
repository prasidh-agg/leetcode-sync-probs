class Solution {
    public int matrixScore(int[][] grid) {
        //flipping the MSB would give the max number
        int m = grid.length, n = grid[0].length;

        //since first column will always be 1 for max score, set that score already
        int score = (int)Math.pow(2, n - 1) * m;

        for(int j = 1; j < n; j++){
            int countSameBits = 0; //count of 1's
            for(int i = 0; i < m; i++){
                if(grid[i][j] == grid[i][0]){
                    countSameBits++;

                }
            }
            int countOnes = countSameBits;
            int countZeroes = m - countOnes;
            
            int ones = Math.max(countOnes, countZeroes);

            score += Math.pow(2, n - j - 1) * ones;

        }
        return score;
    }
}
