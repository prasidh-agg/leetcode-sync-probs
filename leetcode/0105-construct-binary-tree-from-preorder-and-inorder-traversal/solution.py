# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        n = len(inorder)
        inorder_map = {val: i for i, val in enumerate(inorder)}
        idx = [0] # this is done to make sure we can pass it by reference

        return self.build(preorder, inorder_map, 0, n - 1, idx)

    def build(self, preorder: List[int], inorder_map: dict, start: int, end: int, idx: List[int]) -> Optional[TreeNode]:
        if start > end:
            return None
        
        root_val = preorder[idx[0]]
        root_index = inorder_map[root_val]
        idx[0] += 1

        root = TreeNode(root_val)
        root.left = self.build(preorder, inorder_map, start, root_index - 1, idx)
        root.right = self.build(preorder, inorder_map, root_index + 1, end, idx)

        return root
