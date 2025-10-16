# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        self.traversal(root, res)
        return res
        

    def traversal(self, root: Optional[TreeNode], res: List[int]):
        if root is None:
            return
        res.append(root.val)
        self.traversal(root.left, res)
        self.traversal(root.right, res)

        return
