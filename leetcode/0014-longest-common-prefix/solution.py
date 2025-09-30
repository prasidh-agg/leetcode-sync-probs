class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        strs.sort()
        first = strs[0]
        last = strs[-1]

        i = 0
        for a, b in zip(first, last):
            if a != b:
                break
            i += 1
        
        return first[:i]
