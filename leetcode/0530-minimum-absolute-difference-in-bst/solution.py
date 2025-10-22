# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        self.min_diff = float('inf')
        self.prev = None
        self.inorder(root)

        return self.min_diff
    
    def inorder(self, root: Optional[TreeNode]):
        if root is None:
            return

        self.inorder(root.left)
        # this means we have a previous value
        if self.prev is not None:
            self.min_diff = min(self.min_diff, root.val - self.prev)

        self.prev = root.val # set the current value as the previous node, for next diff calculation
        self.inorder(root.right)

