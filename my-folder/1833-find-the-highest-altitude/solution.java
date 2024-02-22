class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int maxHt = 0;

        for(int g : gain){
            sum += g;
            maxHt = Math.max(sum, maxHt);
        }
        return maxHt;
    }
}
