class Solution {

    Map<Integer, List<Integer>> adj = new HashMap<>();
    public int[] restoreArray(int[][] adjacentPairs) {

        for (int[] edge : adjacentPairs) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

      //find element with only one neighbour and start dfs from there
      int startPoint = -1;
      for(int num : adj.keySet()){
          if(adj.get(num).size() == 1){
              startPoint = num;
              break;
          }
      }

      int[] res = new int[adj.size()];
      dfs(startPoint, Integer.MAX_VALUE, res, 0);

        return res;
    }
    private void dfs(int node, int prev, int[] res, int i){
        res[i] = node;
        for(int neighbor : adj.get(node)){
            if(neighbor != prev){
                dfs(neighbor, node, res, i + 1);
            }
        }
    }
}
