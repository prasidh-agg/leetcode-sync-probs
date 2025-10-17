# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        res = []
        q = []

        q.append(root)

        while q:
            level_size = len(q)
            level = []
            while level_size > 0:
                el = q.pop(0)
                level.append(el.val)
                if el.left:
                    q.append(el.left)
                if el.right:
                    q.append(el.right)
                level_size -= 1
            res.append(level[-1])
        
        return res

