class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        if k == 0 or len(nums) == len(set(nums)):
            return False
        
        last = {}
        for i, val in enumerate(nums):
            if val in last and i - last[val] <= k:
                return True
            last[val] = i
        return False
        
