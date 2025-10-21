class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        n = len(nums)
        minPos = maxPos = culPos = -1
        ans = 0

        for i in range(n):
            # if our num is out of bounds, this is a culprit index
            if nums[i] < minK or nums[i] > maxK:
                culPos = i
            
            if nums[i] == minK:
                minPos = i
            
            # it's important to have this as an if, rather than an elif
            # because the same number can be a minK as well as maxK
            if nums[i] == maxK:
                maxPos = i
            
            smallerIndex = min(minPos, maxPos)

            # find potential answers ending at i, if this is neg, it means not possible
            possible_arrays = smallerIndex - culPos

            if possible_arrays > 0:
                ans += possible_arrays
        
        return ans
