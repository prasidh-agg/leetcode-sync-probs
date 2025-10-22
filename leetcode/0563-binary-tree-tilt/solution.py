# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    tilt = 0
    def findTilt(self, root: Optional[TreeNode]) -> int:
        self.helper(root)
        return self.tilt

    def helper(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        # get left and right sums
        left_sum = self.helper(root.left)
        right_sum = self.helper(root.right)

        # calc tilt for this node
        self.tilt += abs(left_sum - right_sum)

        # this function basically returns the total sum to the top nodes
        return left_sum + right_sum + root.val
