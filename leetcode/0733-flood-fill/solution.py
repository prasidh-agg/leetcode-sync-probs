class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        # if starting cell has the same color, just return
        if color == image[sr][sc]:
            return image

        q = []
        m = len(image)
        n = len(image[0])

        self.dfs(sr, sc, color, image, m, n, image[sr][sc])

        return image

    def dfs(self, sr: int, sc: int, color: int, image: List[List[int]], m: int, n: int, startColor: int):
        if sr < 0 or sr >= m or sc < 0 or sc >= n or image[sr][sc] == color or image[sr][sc] != startColor:
            return
        
        image[sr][sc] = color
        self.dfs(sr + 1, sc, color, image, m, n, startColor)
        self.dfs(sr - 1, sc, color, image, m, n, startColor)
        self.dfs(sr, sc + 1, color, image, m, n, startColor)
        self.dfs(sr, sc - 1, color, image, m, n, startColor)

        return

