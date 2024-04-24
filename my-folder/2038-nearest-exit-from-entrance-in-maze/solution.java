class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);

        // Mark the starting node as visited
        maze[entrance[0]][entrance[1]] = '+';

        // Make an array to store all 4 directions
        int[][] directions = new int[][]{{-1,0}, {1,0}, {0, -1}, {0, 1}};
        int level = 0;
        int newX = 0, newY = 0;

        while(!q.isEmpty()){
            level++;
            //this gives me the current node where I am standing and
            //want to traverse all its neighbours
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();

                for(int[] direction: directions){
                    newX = curr[0] + direction[0];
                    newY = curr[1] + direction[1];

                    //if direction out of bound or hit a wall, then skip that direction
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n || maze[newX][newY] == '+') continue;

                    //if cell on the boundary, and hasn't been visited, then it means we have reached the exit
                    if(newX == 0 || newX == m - 1 || newY == 0 || newY == n - 1) return level;

                    //otherwise mark the current cell as visited
                    maze[newX][newY] = '+';
                    //add in the queue to perform bfs in the next level
                    q.offer(new int[]{newX, newY});
                }

            }
        }

        return -1;

    }
}
