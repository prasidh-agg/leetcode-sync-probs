# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.isValid(root, float('-inf'), float('inf'))
    
    def isValid(self, root: Optional[TreeNode], minVal: int, maxVal: int) -> bool:
        if root is None:
            return True
        
        if root.val <= minVal or root.val >= maxVal:
            return False
        
        return self.isValid(root.left, minVal, root.val) and self.isValid(root.right, root.val, maxVal)
