class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //found an island
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        
        //mark as visited by switching to 0
        grid[i][j] = '0';
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int[] direction : directions){
            int newI = i + direction[0];
            int newJ = j + direction[1];
            dfs(grid, newI, newJ);
        }
        return;
    }
}
