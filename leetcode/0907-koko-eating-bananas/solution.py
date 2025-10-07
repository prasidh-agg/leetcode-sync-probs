class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # take biggest pile of bananas as starting speed
        # since number of piles <= h, this means koko can easily finish all piles before 8 hours
        # implement binary search between min and max piles
        l, r = 1, max(piles)

        while l < r:
            # new potential k
            mid = l + (r - l) // 2
            #  l - 3, r - 11, mid = 7 with k = 7, can finish in 5 hours, since we need to find min speed, we can further try to shrink k
            totalHours = 0
            for pile in piles:
                totalHours += math.ceil(pile / mid)
            
            # this means koko can finish before h hours, but lets try to find a slower speed such that we can go closer to h
            if totalHours <= h:
                r = mid
            else:
                l = mid + 1
        
        return r

            
