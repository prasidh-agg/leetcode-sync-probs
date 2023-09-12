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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    private static TreeNode helper(int[] nums, int left, int right){

        if(left > right) return null;

        int mid = left + (right - left)/2;

        // create root with the mid node
        TreeNode root = new TreeNode(nums[mid]);

        // create left tree with the array to the left of the mid
        root.left = helper(nums, left, mid - 1);

        // create right tree with the array to the right of the mid
        root.right = helper(nums, mid + 1, right);
        
        return root;
    }
}

