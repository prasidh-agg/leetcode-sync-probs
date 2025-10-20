class Solution:
    def minimumLength(self, s: str) -> int:
        l, r = 0, len(s) - 1
        while l < r and s[l] == s[r]:
            ch_to_match = s[l]
            while l < r and s[l] == ch_to_match:
                l += 1
            while l <= r and s[r] == ch_to_match:
                r -= 1
        return r - l + 1
