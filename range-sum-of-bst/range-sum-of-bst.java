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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int rangeSum = 0;
        if (root.val <= high && root.val >= low) rangeSum += root.val;
        if (root.val < high && root.right != null) rangeSum += rangeSumBST(root.right, low, high);
        if (root.val > low && root.left != null) rangeSum += rangeSumBST(root.left, low, high);
        return rangeSum;
    }
}

//low 7 high 15
//10 + [0 + 7 + X] + [15 + X]