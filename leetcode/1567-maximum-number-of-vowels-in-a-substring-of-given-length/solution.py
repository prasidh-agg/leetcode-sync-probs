class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowels = set("aeiou")
        n = len(s)
        i = 0
        ans = 0
        curr_vowels = 0

        for j in range(n):
            if s[j] in vowels:
                curr_vowels += 1

            # if reached window length, check how many vowels do we have
            if j - i + 1 == k:
                ans = max(ans, curr_vowels)
                # if window's leftmost char is a vowel, remove it from the curr_vowels count and increment i
                if s[i] in vowels:
                    curr_vowels -= 1
                i += 1
        
        return ans

