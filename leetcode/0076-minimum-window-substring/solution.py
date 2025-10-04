class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "": return ""
        countT = Counter(t)
        window = {}

        have, need = 0, len(countT)
        res, resLen = [-1, -1], len(s) + 1

        l = 0
        for r, ch in enumerate(s):
            window[ch] = 1 + window.get(ch, 0)

            if ch in countT and window[ch] == countT[ch]:
                have += 1
            
            while have == need:
                if(r - l + 1 < resLen):
                    res = [l, r]
                    resLen = r - l + 1
                
                window[s[l]] -= 1
                if s[l] in countT and window[s[l]] < countT[s[l]]:
                    have -= 1
                l += 1
        l, r = res
        return s[l: r + 1] if resLen != len(s) + 1 else ""

