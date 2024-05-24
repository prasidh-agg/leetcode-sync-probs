class Solution {
    public int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    helper(grid, i, j);
                    if(area > maxArea){
                        maxArea = area;
                    }
                    area = 0;
                }
            }
        }
        return maxArea;
    }

    public void helper(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return;
        }
        area++;
        grid[i][j] = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int[] direction : directions){
            int newI = i + direction[0];
            int newJ = j + direction[1];
            helper(grid, newI, newJ);
        }
        return;
    }
}
