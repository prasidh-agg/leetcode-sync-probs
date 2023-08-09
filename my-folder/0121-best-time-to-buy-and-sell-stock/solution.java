class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;

        int min = prices[0];
        int cost = 0;
        for(int i = 1; i < prices.length; i++){
            cost = Math.max(prices[i] - min, cost);
            min = Math.min(min, prices[i]);
        }

        return cost;
    }
}
