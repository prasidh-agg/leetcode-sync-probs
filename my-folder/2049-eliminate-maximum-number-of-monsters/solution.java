class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        for(int i = 0; i < n; i++){
            //convert the distance array to a time array by doing dist/speed
            dist[i] = (int)Math.ceil((double)dist[i]/speed[i]);
        }
        Arrays.sort(dist);
        
        //now the monster that can reach the quickest will be in the beginning of the array
        int count = 1;
        int minsPassed = 1;
        for(int i = 1; i < n; i++){
            if(dist[i] - minsPassed <= 0){
                //cant kill more monsters because the monster reached the city
                return count;
            }
            // we were able to kill this monster
            count++;
            minsPassed++;
        }
        return count;
    }
}
