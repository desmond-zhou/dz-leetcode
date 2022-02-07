// Stores the maximum ans minimum node in this subStree ans the max sum of the valid
// Bst in this subtree
public class Data{
    int largest;
    int smallest;
    int sum;
    public Data(int l, int s, int sz){
        this.largest = l;
        this.smallest = s;
        this.sum = sz;
    }
}



// For a Bst this value of the current node must be greater than the largest value in the left part &&
// it should be smaller than the smallest value ofthe right part.
// left.largest < curr.value < right.smallest

class Solution {
    public int maxSumBST(TreeNode root) {
        if(root == null) return 0;
        Data ans = new Data(0, 0, 0);
        findSum(root, ans);
        return ans.sum < 0 ? 0 : ans.sum;
    }
    
    
    public Data findSum(TreeNode node, Data ans){
        // If left node then return largest as the smallest & smallest as the the max to satisfy the bst
        if(node == null) return new Data(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        
        // Inorder traversal
        Data left = findSum(node.left, ans);
        Data right = findSum(node.right, ans);
        
        // Valid BST Check: left.largest < curr.value < right.smallest
        if(node.val > left.largest && node.val < right.smallest){
            // compare the max sum 
            ans.sum = Math.max(ans.sum, node.val + left.sum + right.sum);
            
            // Get (the max,min,sum) for the curr node and return it
            int max = Math.max(node.val, right.largest);
            int min = Math.min(node.val,left.smallest);
            int sum = node.val + left.sum + right.sum;
            return new Data(max, min, sum);
        }
        
        // If the curr node is not a valid bst then return the value such that no node above this node
        // can be a bst
        return new Data(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.sum, right.sum));
    }
}