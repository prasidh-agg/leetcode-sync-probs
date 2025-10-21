class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:

        n = len(nums)

        # edge cases
        if k == 0:
            return nums

        avgs = [-1] * n
        window_size = (2 * k) + 1 #k elements on the left, k on the right, 1 in the middle

        # if we don't even have enough elements to make a window, just return our avgs array (all -1s)
        if n < window_size:
            return avgs

        curr_sum = 0
        for i in range(window_size):
            curr_sum += nums[i]

        avgs[k] = curr_sum // window_size

        for i in range(window_size, n):
            # remove the leftmost element from the sum
            curr_sum -= nums[i - window_size]

            # add the new element to the sum
            curr_sum += nums[i]

            avgs[i - k] = curr_sum // window_size
        
        return avgs
