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
    List<Integer> arr = new ArrayList<>();

    private TreeNode createBST(int start, int end){
        if(start > end) return null;

        int mid = start + (end - start)/2;
        int val = arr.get(mid);

        TreeNode left = createBST(start, mid - 1);
        TreeNode right = createBST(mid + 1, end);

        TreeNode node = new TreeNode(val, left, right);
        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        TreeNode newRoot = null;

        if(root == null) return null;

        inorder(root);
        newRoot = createBST(0, arr.size() - 1);
        return newRoot;
    }

    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
        return;
    }
}
