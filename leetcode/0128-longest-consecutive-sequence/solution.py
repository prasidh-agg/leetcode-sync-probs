class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        unique = set(nums)
        res = 0

        for num in unique:
            # if lower numbers not in set, it means this is a sequence start
            if num - 1 not in unique:
                curr = num
                #  keep counting up
                while curr in unique:
                    curr += 1

                curr_len = curr - num
                if curr_len > res:
                    res = curr_len
        return res
            
