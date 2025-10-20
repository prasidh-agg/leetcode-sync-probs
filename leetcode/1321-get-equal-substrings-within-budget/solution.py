class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        i = 0
        n = len(s)
        ans = 0
        cost = 0

        for j in range(n):
            cost += abs(ord(s[j]) - ord(t[j]))

            if cost > maxCost: 
                cost -= abs(ord(s[i]) - ord(t[i]))
                i += 1
            
            ans = max(ans, j - i + 1)

        return ans
