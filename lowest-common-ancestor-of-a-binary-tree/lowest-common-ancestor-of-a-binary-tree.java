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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pl = path(root, p);
        List<TreeNode> pq = path(root, q);
        
        int lastIndex = Math.min(pl.size() - 1, pq.size() - 1);
        for (int i = lastIndex; i >= 0; i--) {
            if (pl.get(i).val == pq.get(i).val) {
                return pl.get(i);
            }
        }
        return null;
    }
    
    public List<TreeNode> path(TreeNode root, TreeNode p) {
        ArrayList<TreeNode> path = new ArrayList<>();
        search(root, p, path);
        return path;
    }
    
    public boolean search(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        
        path.add(root);
        if (p.val == root.val) {
            return true;
        }
        
        if (root.left != null && search(root.left, p, path)) return true;
        if (root.right != null && search(root.right, p, path)) return true;
        path.remove(path.size() - 1);
        return false;
    }
}