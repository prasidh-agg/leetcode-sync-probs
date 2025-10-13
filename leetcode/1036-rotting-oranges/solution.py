class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        minutes = 0
        q = []
        fresh = 0

        # add all rotten oranges' coordinates to the queue
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append([i, j])
                elif grid[i][j] == 1:
                    fresh += 1
            
        if fresh == 0:
            return 0
        
        while q:
            level_size = len(q)
            for _ in range(level_size):
                orange = q.pop(0)
                i, j = orange[0], orange[1]

                directions = [[-1,0], [1, 0], [0, -1], [0, 1]]
                for di, dj in directions:
                    ni, nj = i + di, j + dj
                    if 0 <= ni < m and 0 <= nj < n and grid[ni][nj] == 1:
                        fresh -= 1
                        grid[ni][nj] = 2
                        q.append([ni, nj])
            minutes += 1
         
        return -1 if fresh != 0 else minutes - 1
    
    
