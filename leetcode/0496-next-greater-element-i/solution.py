class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)
        st = []
        res = []
        next_greater = [-1] * n2

        for i in range(n2):
            while st and nums2[st[-1]] < nums2[i]:
                idx = st.pop()
                next_greater[idx] = nums2[i]
            st.append(i)

        val_to_idx = {num: idx for idx, num in enumerate(nums2)}

        # for num in nums1:
        #     idx = val_to_idx[num]
        #     res.append(next_greater[idx])
        res = [next_greater[val_to_idx[num]] for num in nums1]
        
        return res
