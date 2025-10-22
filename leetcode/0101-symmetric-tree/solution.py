# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # to be symmetric, the root's left must be equal to the root's right
        return self.helper(root.left, root.right)
    
    def helper(self, left: Optional[TreeNode], right: Optional[TreeNode]) -> bool:
        # this basically checks that if one of them is None, make sure both of them are none
        if left is None or right is None:
            return left == right
        elif left.val != right.val:
            return False
        else:
            return self.helper(left.left, right.right) and self.helper(left.right, right.left)
        

