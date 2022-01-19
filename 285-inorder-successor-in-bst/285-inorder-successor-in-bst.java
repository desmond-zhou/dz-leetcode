/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        search(root, p);
        return succ;
    }
    
    boolean found = false;
    TreeNode succ = null;
    private void search(TreeNode root, TreeNode p) {
        if (root == null) return;
        
        search(root.left, p);
        if (found == true) {
            if (succ == null) succ = root;
            return;
        }
        if (root == p) found = true;
        search(root.right, p);
    }
}