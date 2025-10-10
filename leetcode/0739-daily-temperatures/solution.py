class Solution:
    def dailyTemperatures(self, temps: List[int]) -> List[int]:
        n = len(temps)
        st = []
        res = [0] * n

        for i in range(n):
            while st and temps[st[-1]] < temps[i]:
                idx = st.pop()
                res[idx] = i - idx
            st.append(i)
        
        return res
