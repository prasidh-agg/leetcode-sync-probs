class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        ps = 0 
        n = len(s)
        if n == 0: return True
        for ch in t:
            if ch == s[ps]:
                ps += 1
                if ps == n: return True
        return False
