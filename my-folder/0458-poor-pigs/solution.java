class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // trials = minToTest/minToDie
        // (trials + 1)^pigs = total buckets
        int pigs = 0;
        int trials = (minutesToTest/minutesToDie + 1);
        while(Math.pow(trials, pigs) < buckets){
            pigs++;
        }
        return pigs;
    }
}
