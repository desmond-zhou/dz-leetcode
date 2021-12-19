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

//012345 6
//01234 5
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return assign(nums, 0, nums.length - 1);
    }
    
    public TreeNode assign(int[] nums, int s, int e) {
        if (e < s) return null;
        if (s == e) return new TreeNode(nums[s]);
        
        int m = (s + e)/2;
        TreeNode newNode = new TreeNode(nums[m]);
        newNode.left = assign(nums, s, m-1);
        newNode.right = assign(nums, m+1,e);
        return newNode;
    }
}