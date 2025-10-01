class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        p1 = 0
        p2 = len(nums) - 1

        for num in nums:
            # exact solution found
            curr_sum = nums[p1] + nums[p2]
            if curr_sum == target:
                return [p1 + 1, p2 + 1]

            # we need a bigger number so move p1 forward
            elif curr_sum < target:
                p1 += 1
            
            # we need a smaller number so move p2 back
            else:
                p2 -= 1

        return []

