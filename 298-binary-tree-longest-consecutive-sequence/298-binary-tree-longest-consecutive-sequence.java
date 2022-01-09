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
    public int longestConsecutive(TreeNode root) {
        return search(root)[1];
    }
    
    private int[] search(TreeNode node) {
        int path = 1;
        int max = 1;
        
        if (node.left != null) {
            int[] left = search(node.left);
            if (node.left.val == node.val + 1) path = Math.max(path, left[0] + 1);
            max = Math.max(Math.max(path, max), left[1]);
        }
        
        if (node.right != null) {
            int[] right = search(node.right);
            if (node.right.val == node.val + 1) path = Math.max(path, right[0] + 1);
            max = Math.max(Math.max(path, max), right[1]);
        }
        
        return new int[]{path, max};
    }
}