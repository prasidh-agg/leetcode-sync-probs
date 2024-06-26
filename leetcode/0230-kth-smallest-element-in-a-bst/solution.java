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
    int count = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        //use inorder traversal
        count = k;
        traversal(root);
        return result;
    }
    private void traversal(TreeNode root){
        if(root == null) return;
        traversal(root.left);
        count--;
        if(count == 0){
            result = root.val;
            return;
        }
        traversal(root.right);
        return;
    }
}
