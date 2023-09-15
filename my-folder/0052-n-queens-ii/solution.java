class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.' ;
            }
        }
        return helper(0, board);
    }
    private int helper(int col, char[][] board){
        if(col == board.length){
            return 1;
        }
        int count = 0;
        for(int row = 0; row < board.length; row++){
            if(validate(board, row, col)){
                board[row][col] = 'Q';
                count += helper(col + 1, board);
                board[row][col] = '.';
            }
        }
        return count;
    }
    
    //validate if we can place a queen
    private boolean validate(char[][] board, int row, int col){
        int duprow = row;
        int dupcol = col;

        //check upper diagnal
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row-- ;
            col-- ;
        }

        row = duprow;
        col = dupcol;

        //check left
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col-- ;
        }
        row = duprow;
        col = dupcol;

        //check below diagnal
        while(col >= 0 && row < board.length){
            if(board[row][col] == 'Q') return false;
            row++ ;
            col-- ;
        }
        return true;
    }
}
