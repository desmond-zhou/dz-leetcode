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
    final TreeMap<Integer, ArrayList<Integer>> heightNodes = new TreeMap<>();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        searchWithHeight(root);
        
        List<List<Integer>> result = new ArrayList<>();
        for (ArrayList<Integer> h : heightNodes.values()) {
            result.add(h);
        }
        return result;
    }
    
    public int searchWithHeight(TreeNode node) {
        if (node == null) return 0;
        
        int height = Math.max(searchWithHeight(node.left), searchWithHeight(node.right)) + 1;
        heightNodes.putIfAbsent(height, new ArrayList<Integer>());
        heightNodes.get(height).add(node.val);
        
        return height;
    }
}