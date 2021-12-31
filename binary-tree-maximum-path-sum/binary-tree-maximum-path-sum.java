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
    public int maxPathSum(TreeNode root) {
        return path(root);
    }
    
    private int path(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        
        int pathL = path(root.left);
        int pathR = path(root.right);
        int pathT = arm(root.left) + arm(root.right) + root.val;
        int path = Math.max(pathL, Math.max(pathR, pathT));
        //System.out.println("path: " + root.val + ":" + path);
        return path;
    }
    
    private int arm(TreeNode root) {
        if (root == null) return 0;
        int arm = Math.max(0, root.val + Math.max(arm(root.left), arm(root.right)));
        //System.out.println("arm: " + root.val + ":" + arm);
        return arm;
    }
}

// best height left, best height right, if pos: combined