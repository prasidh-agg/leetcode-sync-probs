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
    private int result;
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        solve(root);
        return result;
    }
    public int[] solve(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int[] p1 = solve(root.left);
        int[] p2 = solve(root.right);
        int totalCount = p1[1] + 1 + p2[1];
        int totalSum = p1[0] + root.val + p2[0];

        if(totalSum / totalCount == root.val) result += 1;
        return new int[]{totalSum, totalCount};
    }
    
}

