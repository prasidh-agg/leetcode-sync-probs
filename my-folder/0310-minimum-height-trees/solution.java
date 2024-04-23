class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if(n == 1) return new ArrayList<>(Arrays.asList(0));
        List<Integer> res = new ArrayList<>();
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            indegree[v]++;
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 1){
                q.offer(i);
            }
        }
        while(n > 2){
            int size = q.size(); //initial size will be 2 because we remove leaf nodes
            n -= size; //remove size from n because those are the leaf nodes
            while(size -- > 0){
                int u = q.poll();
                for(int v : adj.getOrDefault(u, new ArrayList<>())){
                    indegree[v]--;
                    if(indegree[v] == 1){
                        q.offer(v);
                    }
                }
            }
        }
        while(!q.isEmpty()){
            res.add(q.poll());
        }
        return res;
    }
}
