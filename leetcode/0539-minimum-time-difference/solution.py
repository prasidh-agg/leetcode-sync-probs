class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        mins = [False] * 24 * 60
        for time in timePoints:
            splits = time.split(":")
            hours, minutes = int(splits[0]), int(splits[1])
            min_time = (hours * 60) + minutes
            # this means that time with same minutes has been seen before so min diff is 0
            if mins[min_time]:
                return 0
            mins[min_time] = True
        
        prevIndex = firstIndex = lastIndex = ans = float("inf")
        
        for i in range(24 * 60):
            if mins[i]:
                if prevIndex != float("inf"):
                    ans = min(ans, i - prevIndex)
                prevIndex = i
                if firstIndex == float("inf"):
                    firstIndex = i
                lastIndex = i
        
        return min(ans, 24 * 60 - lastIndex + firstIndex)

