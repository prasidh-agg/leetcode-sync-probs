class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        lsum = 0
        rsum = sum(nums)

        for i, num in enumerate(nums):
            rsum -= num
            if lsum == rsum:
                return i
            lsum += num
        
        return -1
            
