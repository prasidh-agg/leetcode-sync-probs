class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        provinces = 0

        adj = [[] for _ in range(n)]
        for i in range(n):
            for j in range(n):
                if isConnected[i][j] == 1:
                    adj[i].append(j)
        
        visited = [False] * n

        for i in range(n):
            if not visited[i]:
                self.dfs(i, adj, visited)
                provinces += 1
        
        return provinces
    
    def dfs(self, u: int, adjList: List[List[int]], visited: List[bool]):
        visited[u] = True

        edges = adjList[u]

        for v in edges:
            if not visited[v]:
                self.dfs(v, adjList, visited)
        
        return
