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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        LinkedList<Pair<TreeNode, Integer>> bsfQ = new LinkedList<>();
        Stack<Pair<TreeNode, Integer>> reverseStack = new Stack<>();
        bsfQ.offer(new Pair<>(root, 0));
        while (!bsfQ.isEmpty()) {
            Pair<TreeNode, Integer> cur = bsfQ.poll();

            reverseStack.push(new Pair<>(cur.getKey(), cur.getValue()));
            
            if (cur.getKey().right != null) bsfQ.offer(new Pair<>(cur.getKey().right, cur.getValue() + 1));
            if (cur.getKey().left != null) bsfQ.offer(new Pair<>(cur.getKey().left, cur.getValue() + 1));
        }
            
        List<List<Integer>> result = new ArrayList<>();
        int curLevel = reverseStack.peek().getValue();
        List<Integer> soFar = new ArrayList<>();
        while(!reverseStack.isEmpty()) {
            Pair<TreeNode, Integer> cur = reverseStack.pop();
            //System.out.println("visit: " + cur.getKey().val + ", " + cur.getValue());
            if (cur.getValue() < curLevel) {
                result.add(soFar);
                curLevel--;
                soFar = new ArrayList<>();
                soFar.add(cur.getKey().val);
            } else {
                soFar.add(cur.getKey().val);
            }
        }
            
        if (!soFar.isEmpty()) {
            result.add(soFar);
        }
        
        return result;
    }
}