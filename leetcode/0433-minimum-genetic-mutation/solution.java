class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        String geneVals = "ACGT";
        //to search valid genes quickly
        Set<String> bankSet = new HashSet<>();
        for(String gene : bank) bankSet.add(gene);

        Set<String> visited = new HashSet<>();

        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        visited.add(startGene);
        int level = 0;

        while(!q.isEmpty()){
            int n = q.size();
            while(n-- > 0){
                String curr = q.poll();
                if(curr.equals(endGene)){
                    return level;
                } 
                for(char ch : geneVals.toCharArray()){
                    for(int i = 0; i < 8; i++){
                        StringBuilder neighbourSb = new StringBuilder(curr);
                        neighbourSb.setCharAt(i, ch);
                        String neighbour = neighbourSb.toString();
                        if(!visited.contains(neighbour) && bankSet.contains(neighbour)){
                            visited.add(neighbour);
                            q.add(neighbour);
                        }
                    }
                }   
            }
            level++;
            
        }
        return -1;

    }
}
