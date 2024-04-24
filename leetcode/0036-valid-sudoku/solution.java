class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !checkValid(board, i ,j, board[i][j])){
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean checkValid(char[][] board, int row, int col, char ch){
        //check row
        for(int i = 0; i < 9 && i != col; i++){
            if(ch == board[row][i]) return false;
        }

        //check col
        for(int j = 0; j < 9 && j != row; j++){
            if(ch == board[j][col]) return false;
        }

        //check square
        for (int i = 0; i < 9; i++) {
            int rowInd = 3 * (row / 3) + i / 3;
            int colInd = 3 * (col / 3) + i % 3;
            if (rowInd != row && colInd != col) {
                if (board[rowInd][colInd] == ch) return false;
            }
        }
        return true;

    }
}
