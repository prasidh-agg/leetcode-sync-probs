class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        maxi = 0
        mini = prices[0]

        for price in prices:
            if price < mini:
                mini = price
            elif price - mini > maxi:
                maxi = price - mini
            
        return maxi
