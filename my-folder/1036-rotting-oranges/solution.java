class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        
        Queue<int[]> q = new LinkedList<>();

        //if the orange is rotten, push it to the queue
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
                else if(grid[i][j] == 1) fresh++;
            }
        }
        if(fresh == 0) return 0;

        int level = 0;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                for(int[] dir : directions){
                    int newX = curr[0] + dir[0], newY = curr[1] + dir[1];
                    
                    //if within bounds, and fresh, mark it rotten and add it to the queue
                    if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1){
                        fresh--;
                        grid[newX][newY] = 2;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            level++;
        }

        return fresh == 0 ? level - 1 : -1;

    }
}
