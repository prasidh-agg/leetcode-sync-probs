class Solution:
    def reverseVowels(self, s: str) -> str:
        l, r = 0, len(s) - 1
        vowels = set("aeiouAEIOU")
        chars = list(s)

        while l < r:
            while l < r and chars[l] not in vowels:
                l += 1
            while l < r and chars[r] not in vowels:
                r -= 1
            
            # swap chars at l and r                
            chars[l], chars[r] = chars[r], chars[l]
            l += 1
            r -= 1
        
        return ''.join(chars)
