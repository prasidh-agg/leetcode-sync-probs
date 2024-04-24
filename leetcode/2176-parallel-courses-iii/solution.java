class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n];
        int[] maxTime = new int[n];
        
        for (int[] vec : relations) {
            int u = vec[0] - 1;
            int v = vec[1] - 1;
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            indegree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                maxTime[i] = time[i];
            }
        }
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            List<Integer> neighbors = adj.getOrDefault(u, new ArrayList<>());
            for (int v : neighbors) {
                maxTime[v] = Math.max(maxTime[v], maxTime[u] + time[v]);
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, maxTime[i]);
        }
        
        return result;
    }
}
