class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                //if land found, add 4 to perimeter
                if(grid[i][j] == 1) {
                    perimeter += 4;
                    //if previous or top one is also island.. subtract 2 for each
                    if(i > 0 && grid[i - 1][j] == 1) perimeter -= 2;
                    if(j > 0 && grid[i][j - 1] == 1) perimeter -= 2;
                }
            }
        }
        return perimeter;
    }
}

