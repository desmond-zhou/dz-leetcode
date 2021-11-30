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
    Integer prev = 0;
    Integer count = 0;
    Integer max = 0;
    
    public int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        search(root, result);
        
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
    
    public void search(TreeNode node, List<Integer> list) {
        if (node == null) return;
        if (node.left != null) search(node.left, list);
        
        if (prev != null && prev == node.val) {
            count++;
        } else {
            prev = node.val;
            count = 1;
        } 
        
        if (count > max) {
            list.clear();
            list.add(node.val);
            max = count;
        } else if (count == max) {
            list.add(node.val);
        }
        
        if (node.right != null) search(node.right, list);
    }
}