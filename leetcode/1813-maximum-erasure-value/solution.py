class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        score = 0
        i = 0
        seen = set()

        for j in range(n):
            while nums[j] in seen:
                score -= nums[i]
                seen.remove(nums[i])
                i += 1
            seen.add(nums[j])
            score += nums[j]

            if score > ans:
                ans = score
        
        return ans
