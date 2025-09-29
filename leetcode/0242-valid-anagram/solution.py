class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): 
            return False

        char_arr = [0]*26
        base = ord('a')

        for a, b in zip(s, t):
            char_arr[ord(a) - base] += 1
            char_arr[ord(b) - base] -= 1

        return not any(char_arr)
        
