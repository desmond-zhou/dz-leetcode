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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> traversal = new Stack<>();
        traversal.push(root);
        TreeNode node = null;
        TreeNode prev = null;
        while(!traversal.isEmpty()) {
            prev = node;
            node = traversal.pop();
         
            if (prev != null) {
                prev.left = null;
                prev.right = node;
            }

            if (node.right != null) traversal.push(node.right);            
            if (node.left != null) traversal.push(node.left);
        }
        
        if (node != null) {
            node.left = null;
            node.right = null;
        }
    }
}