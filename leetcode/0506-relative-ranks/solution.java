class Solution {
    class Athlete{
        private int score;
        private int index;

        public Athlete(int score, int index){
            this.score = score;
            this.index = index;
        }
    }
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];

        PriorityQueue<Athlete> pq = new PriorityQueue<>((a,b) -> b.score - a.score);

        for(int i = 0; i < n; i++){
            pq.add(new Athlete(score[i], i));
        }
        int place = 1;
        while(!pq.isEmpty()){
            Athlete ath = pq.poll();
            int index = ath.index;
            
            if(place == 1){
                res[index] = "Gold Medal";
            }
            else if(place == 2){
                res[index] = "Silver Medal";
            }
            else if(place == 3){
                res[index] = "Bronze Medal";
            }
            else{
                res[index] = String.valueOf(place);
            }
            place++;
            
        }
        return res; 

    }
}
