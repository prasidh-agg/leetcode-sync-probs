class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:
        n = len(nums)
        st = []

        for i in range(n):
            if not st or nums[i] <= nums[st[-1]]:
                st.append(i)
        
        res = 0
        j = n - 1
        while j > 0:
            while st and nums[j] >= nums[st[-1]]:
                idx = st.pop()
                res = max(res, j - idx)
            j -= 1
        
        return res
                
