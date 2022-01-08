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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        ArrayDeque<TreeNode> deck = new ArrayDeque<>();
        deck.push(root);
        HashMap<Integer, TreeNode> levels = new HashMap<>();
        levels.put(0, root);
        int level = 0;
        
        List<Integer> soFar = new ArrayList<>();
        while (!deck.isEmpty()){
            TreeNode node = deck.pop();
            if (levels.containsKey(level + 1) && levels.get(level + 1).equals(node)) {
                level++;
                result.add(soFar);
                soFar = new ArrayList<>();
            }
            soFar.add(node.val);
            if (node.left != null) {
                levels.putIfAbsent(level + 1, node.left);
                deck.add(node.left);
            } 
            if (node.right != null) {
                levels.putIfAbsent(level + 1, node.right);
                deck.add(node.right);
            }
        }
        if (!soFar.isEmpty()) result.add(soFar);
        return result;
    }
    
}