# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        q = []
        q.append(root)
        res = []

        while q:
            level = []
            level_size = len(q)
            while level_size > 0:
                # add the popped element into the current level list
                el = q.pop(0)
                level.append(el.val)
                if el.left: 
                    q.append(el.left)
                if el.right:
                    q.append(el.right)
                level_size -= 1
            res.append(level)
        
        return res
