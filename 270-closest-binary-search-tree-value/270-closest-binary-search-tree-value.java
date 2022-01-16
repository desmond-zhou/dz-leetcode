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
    public int closestValue(TreeNode root, double target) { 
        return search(root, target, null);
    }
    
    public int search(TreeNode cur, double target, Integer currentBest) {
        int newBest;
        if (currentBest == null)  {
            newBest = cur.val;
        } else {
            newBest = pickBetter(cur.val, currentBest, target);
        }
        
        if(cur.left != null) {
            int subBestLeft = search(cur.left, target, newBest);
            newBest = pickBetter(newBest, subBestLeft, target);
        }
        
        if(cur.right != null) {
            int subBestRight = search(cur.right, target, newBest);
            newBest = pickBetter(newBest, subBestRight, target);   
        }
        
        return newBest;
    }
    
    public int pickBetter(int a, int b, double target) {
        double aDiff = Math.abs(a - target);
        double bDiff = Math.abs(b - target);
        return (aDiff < bDiff) ? a : b;
    }
}