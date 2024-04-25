class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int leftMin = prices[0];

        for(int price : prices) {

            //check if our leftMin is still the smallest, just recalc max profit.. by finding cost of selling now
            if(price > leftMin) {
                maxProfit = Math.max(maxProfit, price - leftMin);
            } 
            // this means we found a new leftMin
            else {
                leftMin = price;
            }
        }

        return maxProfit;
    }
}
