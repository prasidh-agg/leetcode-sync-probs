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
    int good;
    public int goodNodes(TreeNode root) {
        good = 0;
        counter(root, Integer.MIN_VALUE);
        return good;
    }
    public void counter(TreeNode root, int pathMax){
        if(root == null) return;
        if(root.val >= pathMax){
            good++;
            pathMax = root.val;
        }
        counter(root.left, pathMax);
        counter(root.right, pathMax);

    }
}
