class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1

        while l < r:
            mid = l + (r - l) // 2

            # if right half sorted, min has to be on the left
            if nums[mid] <= nums[r]:
                r = mid
                
            # left half sorted, min has to be on the right
            else:
                l = mid + 1
            
        return nums[l]
