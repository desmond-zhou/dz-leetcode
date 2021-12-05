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
class Result {
    int rob;
    int noRob;
    public Result(int rob, int noRob) {
        this.rob = rob;
        this.noRob = noRob;
    }
}

class Solution {
    HashMap<TreeNode, Result> memo = new HashMap<>();
    
    public int rob(TreeNode root) {
        Result result = helper(root);
        return Math.max(result.rob, result.noRob);
    }
    
    public Result helper(TreeNode node) {
        if (node == null) return new Result(0, 0);
        if (memo.containsKey(node)) {
            return memo.get(node);
        }
        
        int rob = node.val + helper(node.left).noRob + helper(node.right).noRob;
        int noRob = Math.max(helper(node.left).rob, helper(node.left).noRob) 
            + Math.max(helper(node.right).rob, helper(node.right).noRob);
        Result thisResult = new Result(rob, noRob);
        
        memo.put(node, thisResult);
        return thisResult;
    }
}