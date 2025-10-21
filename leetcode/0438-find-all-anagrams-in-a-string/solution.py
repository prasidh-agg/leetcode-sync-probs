class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        m = len(p)
        n = len(s)
        
        freq1 = [0] * 26
        freq2 = [0] * 26
        
        # build a freq counter of all chars in p
        for k in range(m):
            freq1[ord(p[k]) - ord('a')] += 1
        
        i = j = 0
        res = []
        
        while j < n:
            # increment the freq count of current char at j (right edge of window)
            freq2[ord(s[j]) - ord('a')] += 1

            # if the window becomes invalid (greater than m), shrink one from the left
            if j - i + 1 > m:
                freq2[ord(s[i]) - ord('a')] -= 1
                i += 1
            
            # if size of window and frequencies match, it's an anagram
            if j - i + 1 == m and freq1 == freq2:
                res.append(i)
            
            j += 1
        return res  
