# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while root:
            if p.val < root.val and q.val < root.val:
                # this means that both p and q exist on the left of the root
                root = root.left
            elif p.val > root.val and q.val > root.val:
                # this means that both p and q exist on the right of the root
                root = root.right
            else:
                # this means p and q exist on either side.. so current root must be the LCA
                return root
