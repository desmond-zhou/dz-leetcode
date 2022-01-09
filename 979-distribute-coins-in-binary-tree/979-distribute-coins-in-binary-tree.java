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
    private static int BAL = 0, CNT = 1;
    public int distributeCoins(TreeNode root) {
        return plan(root)[CNT];
    }
    private int[] plan(TreeNode node) {
        if (node == null) return data(0,0);
        else {
            int[] leftPlan = plan(node.left);
            int[] rightPlan = plan(node.right);
            int balance = leftPlan[BAL] + rightPlan[BAL] + (node.val - 1);
            int count = Math.abs(leftPlan[BAL]) + Math.abs(rightPlan[BAL]) + leftPlan[CNT] + rightPlan[CNT];
            return data(balance, count);
        }
    }
    private int[] data(int balance, int count) {
        return new int[]{balance, count};
    }
}