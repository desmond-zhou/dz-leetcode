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
    TreeMap<List<Integer>, ArrayList<Integer>> obj = new TreeMap<>((a,b) -> {
        if (a.get(1) != b.get(1)) return Integer.compare(a.get(1), b.get(1));
        else return Integer.compare(a.get(0), b.get(0));
    });
        
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        search(root, 0, 0);
        int prevCol = Integer.MAX_VALUE;
        for (Map.Entry<List<Integer> , ArrayList<Integer>> entry: obj.entrySet()) {
            if (entry.getKey().get(1) != prevCol) result.add(new ArrayList<Integer>());
            prevCol = entry.getKey().get(1);
            entry.getValue().sort((a,b) -> Integer.compare(a,b));
            result.get(result.size() - 1).addAll(entry.getValue());
        }
        return result;
    }
    
    private void search(TreeNode root, int row, int col) {
        if (root == null) return;
        List<Integer> key = List.of(row, col);
        obj.putIfAbsent(key, new ArrayList<Integer>());
        obj.get(key).add(root.val);
        
        search(root.left, row + 1, col - 1);
        search(root.right, row + 1, col + 1);
    } 
}