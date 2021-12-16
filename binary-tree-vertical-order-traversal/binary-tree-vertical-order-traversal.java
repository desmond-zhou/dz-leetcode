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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        HashMap<TreeNode, Integer> column = new HashMap<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        column.put(root, 0);
        queue.offer(root);
        HashMap<Integer, List<Integer>> result = new HashMap<>();
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int col = column.get(cur);
            result.putIfAbsent(col, new ArrayList<>());
            result.get(col).add(cur.val);
            
            if (cur.left != null) {
                column.put(cur.left, col - 1);
                queue.offer(cur.left);
            } 
            
            if (cur.right != null) {
                column.put(cur.right, col + 1);
                queue.offer(cur.right);
            }
        }
        
        List<Integer> sortedKeys = new ArrayList<Integer>(result.keySet());
        Collections.sort(sortedKeys);
        List<List<Integer>> output = new ArrayList<>();
        for (int k : sortedKeys) {
            System.out.println(k);
            output.add(result.get(k));
        }
        return output;
    }
}