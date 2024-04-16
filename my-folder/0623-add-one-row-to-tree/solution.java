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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            return new TreeNode(val, root, null);
        }
        helper(root, 1, depth, val);
        return root;
    }
    public void helper(TreeNode root, int currDepth, int depth, int val){
        if(root == null) return;

        if(currDepth == depth - 1){
            TreeNode left = root.left;
            root.left = new TreeNode(val, left, null);
            TreeNode right = root.right;
            root.right = new TreeNode(val, null, right);
            return;
        }
        helper(root.left, currDepth + 1, depth, val);
        helper(root.right,currDepth + 1, depth, val);
        return;
    }
}
