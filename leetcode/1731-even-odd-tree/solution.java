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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean evenLevel = true;

        while(!q.isEmpty()){
            int n = q.size(); //n elements in curr level

            int prev = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while(n > 0){
                n--;
                TreeNode currNode = q.poll();
                if(evenLevel && (currNode.val % 2 == 0 || currNode.val <= prev)){
                    return false;
                }
                if(!evenLevel && (currNode.val % 2 != 0 || currNode.val >= prev)){
                    return false;
                }
                prev = currNode.val;
                if(currNode.left != null)q.offer(currNode.left);
                if(currNode.right != null)q.offer(currNode.right);
            }
            evenLevel = !evenLevel;
        }
        return true;
    }
}
