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
    public int goodNodes(TreeNode root) {
        return search(root, Integer.MIN_VALUE);
    }
    
    private int search(TreeNode node, int largestBefore) {
        if (node == null) return 0;
        
        int count = 0;
        if (node.val >= largestBefore) count++;
        int largestWith = Math.max(largestBefore, node.val);
        count += search(node.left, largestWith);
        count += search(node.right, largestWith);
        return count;
    }
}