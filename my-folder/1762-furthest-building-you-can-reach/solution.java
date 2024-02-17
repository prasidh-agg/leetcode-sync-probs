class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int i;
        for(i = 0; i < n - 1; i++){
            //next building is smaller than or equal to current one
            if(heights[i + 1] <= heights[i]) continue;

            int diff = heights[i + 1] - heights[i];
            if(bricks >= diff){
                bricks -= diff;
                pq.add(diff);
            }
            else if(ladders > 0){
                //either use ladders, or check in past if we used too  many bricks
                if(!pq.isEmpty()){
                    int maxBricksPast = pq.peek();
                    if(maxBricksPast > diff){
                        bricks += maxBricksPast;
                        pq.poll();
                        bricks -= diff;
                        pq.add(diff);
                        ladders-- ;
                    }
                    else{
                        ladders--;
                    }
                }
                else{
                    ladders--;
                }
            }
            else{
                break;
            }
        }
        return i;
    }
}
