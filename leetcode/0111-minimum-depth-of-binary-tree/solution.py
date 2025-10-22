# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        q = [(root, 1)] # initialize the root node in the q, with depth of 1

        while q:
            node, depth = q.pop(0)

            # found a leaf node, return depth
            if node.left is None and node.right is None:
                return depth
            
            if node.left:
                q.append((node.left, depth + 1))
            
            if node.right:
                q.append((node.right, depth + 1))
        
        return 0 #redundant
