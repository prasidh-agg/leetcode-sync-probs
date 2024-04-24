class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 1;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / middle)
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / mid);
            }

            if(hourSpent <= h) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
