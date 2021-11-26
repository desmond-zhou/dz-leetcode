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
    int targetSum;
    List<List<Integer>> pathList;
    LinkedList<Integer> valsSoFar;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        this.targetSum = targetSum;
        this.pathList = new LinkedList<>();
        this.valsSoFar = new LinkedList<>();
        if (root == null) {
            return pathList;
        }
        dfs(root, 0);
        return pathList;
    }
    
    public void dfs(TreeNode cur, int sumSoFar) {
        valsSoFar.add(cur.val);
        sumSoFar = sumSoFar + cur.val;
                
        if (cur.left != null) {
            dfs(cur.left, sumSoFar);
        }
        
        if (cur.right != null) {
            dfs(cur.right, sumSoFar);
        }
        
        if (cur.left == null && cur.right == null) {
            if (sumSoFar == targetSum) {
                pathList.add(valsSoFar);
                valsSoFar = new LinkedList<>(valsSoFar);
            }
        }        
        
        valsSoFar.removeLast();
        sumSoFar = sumSoFar - cur.val;
    }
}