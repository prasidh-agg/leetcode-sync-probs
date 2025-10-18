class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        res = 0
        nums.sort()
        l, r = 0, len(nums) - 1
        while l <= r:
            if nums[l] + nums[r] <= target:
                res = (res + pow(2, r - l, 1000000007)) % 1000000007
                l += 1
            else:
                r -= 1
        return res
