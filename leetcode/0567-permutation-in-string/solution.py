class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        m = len(s1)
        n = len(s2)
        if m > n:
            return False

        # we need to find a window in s2, such that all chars in it match all chars in s1
        count = Counter(s1)
        i = 0

        freq1 = [0] * 26
        freq2 = [0] * 26

        for k in range(m):
            freq1[ord(s1[k]) - ord('a')] += 1

        for j in range(n):
            freq2[ord(s2[j]) - ord('a')] += 1

            if j - i + 1 > m:
                freq2[ord(s2[i]) - ord('a')] -= 1
                i += 1
            
            if j - i + 1 == m and freq1 == freq2:
                return True
        return False

