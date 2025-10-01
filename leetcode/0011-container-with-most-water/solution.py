class Solution:
    def maxArea(self, height: List[int]) -> int:
        n = len(height)
        l = 0
        r = n - 1
        max_area = min(height[l], height[r]) * (r - l)

        while l < r:
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
            area = min(height[l], height[r]) * (r - l)
            if area > max_area:
                max_area = area

        return max_area
