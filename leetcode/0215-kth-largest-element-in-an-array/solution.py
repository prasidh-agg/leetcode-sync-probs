class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        klist = []

        # add first k elements to build the heapq
        for i in range(k):
            heapq.heappush(klist, nums[i])

        # for the rest of the elements, if the new element is greater than smallest element, poll the smallest and add this new one
        for i in range(k, len(nums)):
            if nums[i] > klist[0]:
                heapq.heappop(klist)
                heapq.heappush(klist, nums[i])

        return klist[0]
