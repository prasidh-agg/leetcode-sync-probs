/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        // if we have reached null, it means we are at left leaf
        // perform recursion on tree..
        return dfs(root, false);

    }
    public int dfs(TreeNode root, boolean isLeft){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return isLeft ? root.val : 0;
        }
        int left = dfs(root.left, true);
        int right = dfs(root.right, false);
        return left + right;
    }
}
