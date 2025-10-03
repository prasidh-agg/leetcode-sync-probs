class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        res = left = maxf = 0
        chars = defaultdict(int)

        for right, c in enumerate(s):
            chars[c] += 1
            maxf = max(maxf, chars[c])

            if (right - left + 1) - maxf > k:
                chars[s[left]] -= 1
                left += 1
            
            res = max(right - left + 1, res)
        
        return res
            
            

            
                

