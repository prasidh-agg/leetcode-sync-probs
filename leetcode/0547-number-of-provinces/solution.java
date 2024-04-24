class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] vis = new boolean[V];
        int provinces = 0;

        //perform dfs on all nodes
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(isConnected, i, vis);
                provinces++;
            }
        }

        //number of dfs calls equal number of provinces
        return provinces;
    }
    public static void dfs(int[][] adjMatrix, int u, boolean[] vis){
        vis[u] = true;
        for (int v = 0; v < adjMatrix.length; v++) {
            if (adjMatrix[u][v] == 1 && !vis[v]) {
                dfs(adjMatrix, v, vis);
            }
        }
    }
}
