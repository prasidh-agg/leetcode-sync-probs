class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        islands = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j, m, n)
                    islands += 1
        
        return islands
    
    def dfs(self, grid: List[List[str]], i: int, j: int, m: int, n: int) -> None:
        if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] == '0':
            return None
        grid[i][j] = '0'

        self.dfs(grid, i + 1, j, m, n) # check below
        self.dfs(grid, i - 1, j, m, n) # check above
        self.dfs(grid, i, j + 1, m, n) # check right
        self.dfs(grid, i, j - 1, m, n) # check left

        return



