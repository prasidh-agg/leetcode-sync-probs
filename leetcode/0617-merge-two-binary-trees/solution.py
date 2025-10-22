# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def mergeTrees(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> Optional[TreeNode]:
        # if none exist, return none
        if root1 is None and root2 is None:
            return None

        # now one root must exist, so create a new node
        newRoot = TreeNode(0)
        if root1 and root2:
            newRoot.val = root1.val + root2.val
        
        elif root1:
            newRoot.val = root1.val
        
        elif root2:
            newRoot.val = root2.val
        
        newRoot.left = self.mergeTrees(root1.left if root1 else None, root2.left if root2 else None)
        newRoot.right = self.mergeTrees(root1.right if root1 else None, root2.right if root2 else None)

        return newRoot
