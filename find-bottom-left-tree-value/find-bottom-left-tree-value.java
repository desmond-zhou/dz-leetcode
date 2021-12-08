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
    Integer result = null;
    
    public int findBottomLeftValue(TreeNode root) {
        search(root, maxHeight(root) - 1);
        return result == null ? -1 : result.intValue();
    }
    
    public void search(TreeNode node, int height) {
        if (node == null) return; 
        if (height == 0) result = node.val; 
        if (result == null) search(node.left, height - 1);
        if (result == null) search(node.right, height - 1);
    }
    
    public int maxHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxHeight(node.left), maxHeight(node.right)) + 1;
    }
}