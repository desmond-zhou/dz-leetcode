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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum, int curSum) {
        if (root == null) {
            return false;
        }
        
        if (root.left == null && root.right == null) {
            return (curSum + root.val == targetSum);
        }
        
        if (hasPathSum(root.left, targetSum, curSum + root.val)) return true;
        if (hasPathSum(root.right, targetSum, curSum + root.val)) return true;
        return false;
    } 
}