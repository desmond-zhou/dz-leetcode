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
class State {
    int level;
    TreeNode node; 
    public State(int level, TreeNode node) {
        this.level = level;
        this.node = node;
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<State> state = new LinkedList<>();
        state.add(new State(1, root));
        int maxLevel = 0;
        while (!state.isEmpty()) {
            State s = state.poll();
            if (s.node.left == null && s.node.right == null) {
                return s.level;
            }
            maxLevel = s.level;
            if (s.node.left != null) {
                state.add(new State(s.level+1, s.node.left));
            }
            if (s.node.right != null) {
                state.add(new State(s.level+1, s.node.right));
            }
        }
        return maxLevel;
    }
}