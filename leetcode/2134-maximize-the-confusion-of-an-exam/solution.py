class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        n = len(answerKey)
        i = 0
        ans = 0
        countT = countF = 0

        for j in range(n):
            if answerKey[j] == 'T':
                countT += 1
            else:
                countF += 1
            
            # window becomes invalid, if the lesser frequent ('T' or 'F') char occurs more than k times
            while min(countT, countF) > k:
                if answerKey[i] == 'T':
                    countT -= 1
                else:
                    countF -= 1
                i += 1
            
            ans = max(ans, j - i + 1)
        
        return ans
            
