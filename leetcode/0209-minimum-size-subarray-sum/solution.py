class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        left = curr_sum = 0

        # 1 more than max possible len
        res = n + 1 
        
        for right, num in enumerate(nums):
            curr_sum += num

            while curr_sum >= target and left <= right:
                res = min(res, right - left + 1)
                curr_sum -= nums[left]
                left += 1
        
        return 0 if res > n else res

            




