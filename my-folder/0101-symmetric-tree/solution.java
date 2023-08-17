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
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }
    public boolean helper(TreeNode rootLeft, TreeNode rootRight){
        if(rootLeft == null || rootRight == null){
            return rootLeft == rootRight;
        }
        else if(rootLeft.val != rootRight.val){
            return false;
        }
        else{
            return helper(rootLeft.left, rootRight.right) && helper(rootLeft.right, rootRight.left);
        }
    }
}
