# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        # -1 is returned by height check for imbalanced tree
        return self.heightCheck(root) != -1

    def heightCheck(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        
        lht = self.heightCheck(root.left)

        if lht == -1:
            return -1

        rht = self.heightCheck(root.right)
        
        if rht == -1:
            return -1

        if abs(lht - rht) > 1:
            return -1
        
        return 1 + max(lht, rht)

