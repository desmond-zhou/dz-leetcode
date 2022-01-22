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
    int nextDepth = 0;
    boolean isVisited = false;
    TreeNode foundNext = null;
    
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        search(root, u, 0);
        return foundNext;
    }
    
    public void search(TreeNode cur, TreeNode u, int depth) {        
        if (cur == null) {
            return;    
        }
        
        if (foundNext != null) {
            return;
        }
        
        if (cur.val == u.val) {
            nextDepth = depth;
            isVisited = true;
            return;
        }
        
        if (depth == nextDepth && isVisited) {
            foundNext = cur;
            return;
        }
        
        search(cur.left, u, depth + 1);
        search(cur.right, u, depth + 1);
    }
}