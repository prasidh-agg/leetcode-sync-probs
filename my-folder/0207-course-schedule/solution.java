class Solution {
    public boolean canFinish(int numCourses, int[][] matrix) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        } 
        for(int[] arr : matrix){
            int a = arr[0];
            int b = arr[1];
            indegree[a]++;
            adj.get(b).add(a);
        }

        return topologicalSortCheck(adj, numCourses, indegree);
    }
    public boolean topologicalSortCheck(List<List<Integer>> adj, int numCourses, int[] indegree){
        int count = 0;
        //try to perform topological sort on the graph using BFS (kahn's algo)
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                count++;
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    count++;
                    q.offer(v);
                }
            }
        }
        return count == numCourses;
    }
}
