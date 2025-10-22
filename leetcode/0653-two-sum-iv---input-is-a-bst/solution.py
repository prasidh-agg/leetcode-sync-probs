# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        # maintain a hashset to check what vals have been seen till now
        seen = set()   
        return self.helper(root, seen, k)

    def helper(self, root: Optional[TreeNode], seen: set, k: int):
        if root is None:
            return False
        
        # if target - root.val has been seen before, immed return true
        if k - root.val in seen:
            return True
        
        # keep adding seen values till now
        seen.add(root.val)

        # check if we can find the target in left subtree or right subtree
        return self.helper(root.left, seen, k) or self.helper(root.right, seen, k)

