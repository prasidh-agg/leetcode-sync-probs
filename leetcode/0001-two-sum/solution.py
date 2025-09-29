class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        my_dict = {}
        for idx, val in enumerate(nums):
            diff = target - val
            if diff in my_dict:
                return [idx, my_dict[diff]]
            my_dict[val] = idx
        return []

