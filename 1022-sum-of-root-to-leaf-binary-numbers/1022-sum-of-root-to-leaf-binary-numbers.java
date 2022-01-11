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
    public int sumRootToLeaf(TreeNode root) {
        return search(root, 0);
    }
    
    public int search(TreeNode node, int soFar) {
        if (node == null) return 0;
        
        int cur = soFar * 2 + node.val;
        
        if (node.left == null && node.right == null) return cur;
        
        int sum = 0;
        sum += search(node.left, cur);
        sum += search(node.right, cur);
        return sum;
    }
}