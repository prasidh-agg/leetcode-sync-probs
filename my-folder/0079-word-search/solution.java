class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(search(board, word, visited, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
        public boolean search(char[][] board, String word, boolean[][] visited, int i, int j, int wordLen){
            if(wordLen == word.length()){
                return true;
            }
            if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
                return false;
            }
            if(visited[i][j] || board[i][j] != word.charAt(wordLen)){
                return false;
            }
            visited[i][j] = true;
            boolean result = search(board, word, visited, i - 1, j, wordLen + 1) || search(board, word, visited, i + 1, j, wordLen + 1) || search(board, word, visited, i , j - 1, wordLen + 1) || search(board, word, visited, i, j + 1, wordLen + 1);
            visited[i][j] = false;
            return result;
        }
}
