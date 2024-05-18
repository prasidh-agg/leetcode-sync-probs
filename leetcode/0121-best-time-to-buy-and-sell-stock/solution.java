class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int leftMin = prices[0];

        for(int i = 1; i < prices.length; i++) {

            //check if our leftMin is still the smallest, just recalc max profit.. by finding cost of selling now
            if(prices[i] > leftMin) {
                maxProfit = Math.max(maxProfit, prices[i] - leftMin);
            } 
            // this means we found a new leftMin
            else {
                leftMin = prices[i];
            }
        }

        return maxProfit;
    }
}
