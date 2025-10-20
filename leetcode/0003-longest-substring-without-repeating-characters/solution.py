class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        i = 0
        n = len(s)
        ans = 0
        seen = set()

        for j in range(n):
            while s[j] in seen:
                # keep removing from left until we don't eliminate the element our right is standing on
                seen.remove(s[i])
                i += 1
            
            seen.add(s[j])
            ans = max(ans, j - i + 1)

        return ans
