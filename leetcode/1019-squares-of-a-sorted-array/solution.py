class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        n = len(nums)
        l = 0
        r = x = n - 1
        res = [0] * n

        while l <= r:
            if abs(nums[r]) >= abs(nums[l]):
                res[x] = nums[r] ** 2
                r -= 1
            else:
                res[x] = nums[l] ** 2
                l += 1
            x -= 1
        
        return res

