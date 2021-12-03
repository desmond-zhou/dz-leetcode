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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValid(root, arr, 0);
    }
    
    public boolean isValid(TreeNode node, int[] arr, int index) {
        if (node == null) {
            if (index == arr.length) return true;
            else return false;
        }
        
        if (index == arr.length - 1) {
            if (node.val == arr[index] && node.left == null && node.right == null) return true;
            else return false;
        }
            
        if (node.val == arr[index] && (isValid(node.left, arr, index+1) || (isValid(node.right, arr, index+1)))) return true;
        else return false;
    }
}