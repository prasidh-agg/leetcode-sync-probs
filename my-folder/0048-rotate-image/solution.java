class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Step 1: Swap elements across the diagonal
        swapDiagonal(matrix, m, n);
        
        // Step 2: Reverse each row
        reverseRows(matrix, m, n);
    }

    // Swap elements i,j with j,i. Keep in mind that second loop
    // starts from j = i, because otherwise same elements will 
    // keep getting swapped again and again
    private void swapDiagonal(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // Helper method to reverse elements in each row
    private void reverseRows(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}

