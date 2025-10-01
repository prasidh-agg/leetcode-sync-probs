class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()

        # [-4, -1, -1, 0, 1, 2]
        size = len(nums)
        triplets = []

        # we need atleast 3 elements so stop i before that
        for i in range(size):
            # if element is same as the previous one, just skip finding another triplet for it
            if i > 0 and nums[i] == nums[i-1]: continue

            # if at any time the element to fix becomes > 0, break out of the loop. 
            if nums[i] > 0: break

            j = i + 1
            k = size - 1
            target = -nums[i]

            while j < k:
                if nums[j] + nums[k] == target:
                    triplets.append([nums[i], nums[j], nums[k]])
                    j += 1
                    k -= 1
                    while j < k and nums[j] == nums[j-1]: j += 1
                    while j < k and nums[k] == nums[k+1]: k -= 1

                elif nums[j] + nums[k] < target:
                    j += 1
                else:
                    k -= 1

        return triplets




            
        
