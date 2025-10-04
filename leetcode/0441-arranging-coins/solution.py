class Solution:
    def arrangeCoins(self, n: int) -> int:
        l, r = 1, n

        while l <= r:
            mid = l + (r - l) // 2
            coins_needed = mid * (mid + 1) / 2
            if coins_needed == n:
                return mid
            elif coins_needed < n:
                l = mid + 1
            else:
                r = mid - 1
        
        return r
