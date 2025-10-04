class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hash_map = {0 : 1}

        res = 0
        curr_sum = 0

        for num in nums:
            curr_sum += num
            if curr_sum - k in hash_map:
                res += hash_map[curr_sum - k]
            hash_map[curr_sum] = hash_map.get(curr_sum, 0) + 1
        
        return res

