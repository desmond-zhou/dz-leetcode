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
    public List<Integer> rightSideView(TreeNode root) {
        TreeMap<Integer, int[]> resultByDepth = new TreeMap<>();
        search(root, resultByDepth, 0, 0);
        
        return resultByDepth.entrySet().stream().map(e -> e.getValue()[0]).collect(Collectors.toList());
    }
    
    public void search(TreeNode cur, TreeMap<Integer, int[]> result, int column, int depth) {
        if (cur == null) return;
        search(cur.right, result, column + 1, depth + 1);
        result.putIfAbsent(depth, new int[]{cur.val, column, depth});
        search(cur.left, result, column - 1, depth + 1);
    }
}