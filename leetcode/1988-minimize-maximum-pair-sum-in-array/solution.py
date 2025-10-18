class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        nums.sort()
        l, r = 0, len(nums) - 1
        res = []

        while l < r:
            res.append(nums[l] + nums[r])
            l += 1
            r -= 1
        
        return max(res)

