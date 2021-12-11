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
    ArrayList<Integer> leftB = new ArrayList<>();
    ArrayList<Integer> leaves = new ArrayList<>();
    ArrayList<Integer> rightB = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        searchLB(root.left);
        searchL(root, root); //BUG root is not a leave
        searchRB(root.right);
        
        ArrayList<Integer> boundary = new ArrayList<>();
        boundary.add(root.val);
        boundary.addAll(leftB);
        boundary.addAll(leaves);
        Collections.reverse(rightB);
        boundary.addAll(rightB);
        return boundary;
    }
    
    boolean searchLBEnd = false;
    private void searchLB(TreeNode node) {
        if (node == null) return;
        if (searchLBEnd) return;
        if (node.left == null && node.right == null) {
            searchLBEnd = true;
            return;
        } 
        leftB.add(node.val);
        if (node.left != null) searchLB(node.left);
        if (node.right != null) searchLB(node.right);
    }

    private void searchL(TreeNode node, TreeNode exclude) {
        if (node == null) return;
        if (node.left == null && node.right == null && node != exclude) 
            leaves.add(node.val);
        if (node.left != null) searchL(node.left, exclude);
        if (node.right != null) searchL(node.right, exclude);
    }
            
    //NOTE: Must be some way to traverse RB in the reverse order, allowing combined traversal.
    boolean searchRBEnd = false;
    private void searchRB(TreeNode node) {
        if (node == null) return;
        if (searchRBEnd) return;
        if (node.left == null && node.right == null) {
            searchRBEnd = true;
            return;
        } 
        rightB.add(node.val);
        if (node.right != null) searchRB(node.right);
        if (node.left != null) searchRB(node.left);
    }
}