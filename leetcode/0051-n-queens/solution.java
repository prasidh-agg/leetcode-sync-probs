class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.' ;
            }
        }
        helper(0, board, ans);
        return ans;
    }
    
    
    private void helper(int col, char[][] board, List<List<String>> ans){
        if(col == board.length){
            ans.add(construct(board));
            return;
        }
        for(int row = 0; row < board.length; row++){
            if(validate(board, row, col)){
                board[row][col] = 'Q';
                helper(col + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }
    //pass char array to a new string constructor
    private List<String> construct(char[][] board){
        List<String> ds = new ArrayList();
        for(char[] row : board){
            ds.add(new String(row));
        }
        return ds;
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
