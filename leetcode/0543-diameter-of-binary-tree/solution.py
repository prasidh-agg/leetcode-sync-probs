# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    diameter = 0
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.ht(root)
        return self.diameter

    def ht(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0

        left_ht = self.ht(root.left)
        right_ht = self.ht(root.right)
        curr_diameter = left_ht + right_ht
        if curr_diameter > self.diameter:
            self.diameter = curr_diameter
        return 1 + max(left_ht, right_ht)
