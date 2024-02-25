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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key < root.val){
            root.left = deleteNode(root.left, key);
            return root;
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
            return root;
        }
        else{
            //case where we need to now delete the found node
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                //case where we need to rearrange the tree
                TreeNode min = root.right;

                //we are basically finding the smallest element in the right
                //subtree of the node to be deleted.. because it will be bigger
                //than all elements to the left of the node to be deleted..
                while(min.left != null){
                    min = min.left;
                }

                //copy the value of the minimum node to the current node
                //to save it
                root.val = min.val;

                //now since we already copied the value of the minimum node from the right
                // recursively delete the duplicated node
                root.right = deleteNode(root.right, min.val);
                return root;
            }
        }
    }
}
