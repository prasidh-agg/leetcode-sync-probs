class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        # instead of taking a big number, set max to one greater than length of the array
        ans = n + 1
        i = 0
        curr_sum = 0

        for j in range(n):
                curr_sum += nums[j]

                # as long as curr_sum is greater or equal to target, keep shrinking to find a smaller window
                while curr_sum >= target:
                    ans = min(ans, j - i + 1)
                    curr_sum -= nums[i]
                    i += 1
            
        return 0 if ans > n else ans
