class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        i = 0
        n = len(nums)
        ans = 0
        cnt = 0

        for j in range(n):
            # we can do this because if num is 0, we don't want to increment
            # if num is 1, we want the count to increase by 1
            cnt += nums[j] == 0

            # window becomes invalid if the length of the window - (1s in the window), exceeds 1 (we can only delete 1)
            while cnt > 1:
                cnt -= nums[i] == 0
                i += 1
            
            ans = max(ans, j - i)

        return ans
