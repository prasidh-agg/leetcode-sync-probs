class Solution:
    def mySqrt(self, x: int) -> int:
        l = 1
        r = x

        while l <= r:
            mid = l + (r - l) // 2
            if mid * mid == x:
                return mid
            elif mid * mid < x:
                l = mid + 1
            else:
                r = mid - 1
        return l - 1

        # l = 1, r = 8
        # mid = 4 -> l = 1, r = 3
        # mid = 2 -> l = 2, r = 3
        # mid = 2 -> l = 3, r = 3
        

