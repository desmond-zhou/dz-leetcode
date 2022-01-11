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
class Item {
    public TreeNode node;
    public Integer layer;
    public Item(TreeNode node, Integer layer) {
        this.node = node;
        this.layer = layer;
    }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        LinkedList<Item> items = new LinkedList<>(); 
        ArrayList<Integer> max = new ArrayList<>();
        
        if (root == null) {
            return new ArrayList<>();
        }
         
        int curLayer = 1;
        items.add(new Item(root, 1));
        Integer curMax = null;  
        while(!items.isEmpty()){
            Item item = items.poll();
            if (item.layer > curLayer) {
                max.add(curMax);
                curLayer = curLayer + 1;
                curMax = item.node.val;
            } else {
                if (curMax == null || item.node.val > curMax) {
                    curMax = item.node.val;
                }
            }
            
            if (item.node.left != null) {
                items.add(new Item(item.node.left, item.layer + 1));
            } 
            
            if (item.node.right != null) {
                items.add(new Item(item.node.right, item.layer + 1));
            }
        }
        
        max.add(curMax);
        
        return max;
    }
}