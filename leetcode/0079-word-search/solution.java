class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //if found the starting character, then do a dfs search
                if(board[i][j] == word.charAt(0) && find(board, word, visited, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, boolean[][] visited, int i, int j, int pos){
        //this means entire word was found
        if(pos == word.length()) return true;

        //checking out of bounds
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;

        if(visited[i][j] || word.charAt(pos) != board[i][j]) return false;

        visited[i][j] = true;
        boolean result = find(board, word, visited, i - 1, j, pos + 1) || 
                        find(board, word, visited, i + 1, j, pos + 1) ||
                        find(board, word, visited, i , j - 1, pos + 1) || 
                        find(board, word, visited, i, j + 1, pos + 1);
        visited[i][j] = false;
        return result;
    }
}
