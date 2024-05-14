class Solution {
    int m = 0;
    int n = 0;
    int max = 0;

    private int checkNoZeroes(int[][] grid, int m, int n){
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    return -1;
                }
                count += grid[i][j];
            }
        }
        return count;
    }
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int count = checkNoZeroes(grid, m, n);
        if(count != -1) return count;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    dfs(grid, i, j, 0);
                }
            }
        }
        return max;
    }
    private void dfs(int[][] grid, int i, int j, int cur){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0){
            max = Math.max(max, cur);
            return;
        }
        int val = grid[i][j];
        grid[i][j] = 0;
        dfs(grid, i + 1, j, cur + val);
        dfs(grid, i - 1, j, cur + val);
        dfs(grid, i, j + 1, cur + val);
        dfs(grid, i, j - 1, cur + val);

        grid[i][j] = val;
    }
}
