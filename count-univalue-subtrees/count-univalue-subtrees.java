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
    public int countUnivalSubtrees(TreeNode root) {
        return count(root)[0];
    }  
    
    public int[] count(TreeNode root) {
        if (root == null) return new int[]{0, 1};
        if (root.left == null && root.right == null) return new int[]{1, 1};
        
        int[] left = count(root.left);
        int[] right = count(root.right);
        
        boolean tip = false;
        if (left[1] == 1
            && right[1] == 1 
            && (root.left == null || root.left.val == root.val)
            && (root.right == null || root.right.val == root.val)) tip = true; 
            
        if (tip) return new int[]{left[0] + right[0] + 1, 1};
        else return new int[]{left[0] + right[0] , 0};
    }
}