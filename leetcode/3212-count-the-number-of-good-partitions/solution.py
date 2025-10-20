class Solution:
    def numberOfGoodPartitions(self, nums: List[int]) -> int:
        MOD = 10 ** 9 + 7
        n = len(nums)
        last = {value: i for i, value in enumerate(nums)}
        partitions = 1

        j = 0

        for i in range(n):
            if i > j:
                partitions = (partitions * 2) % MOD
            
            # Update right boundary if current element extends it
            if last[nums[i]] > j:
                j = last[nums[i]]
        
        return partitions
