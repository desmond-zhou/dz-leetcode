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
    boolean foundStart = false;
    boolean foundDest = false;
    boolean reversed = false;

    LinkedList<Character> path = new LinkedList<Character>();
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        traverse(root, startValue, destValue);
        return pathToString();
    }
    
    Map<Character, Character> reverseMap = Map.of('L','U','R','U','l','L','r','R');
    Map<Character, Character> convertMap = Map.of('L','L','R','R','l','U','r','U');
    
    public String pathToString() {
        StringBuilder sb = new StringBuilder();
        if (!reversed) Collections.reverse(path);
        final Map<Character, Character> map = reversed ? reverseMap : convertMap;
        for (Character p : path) sb.append(map.get(p));
        return sb.toString();
    }
    
    public void mark(char chara) {
        if (foundStart && foundDest) return;
        else if (foundStart || foundDest) {
            final Character tip = path.peek();
            if (tip != null && tip == reverseMap.get(chara)) {
                path.pop();
            } else 
                path.push(chara);
        }
    }
    
    public void traverse(TreeNode node, int start, int dest) {
        if (node == null) {
            return;
        }
        if (node.val == start) foundStart = true;
        if (node.val == dest) foundDest = true;
        if (foundDest && ! foundStart) reversed = true;
        
        if (foundStart && foundDest) return;
        else {
            if (node.left != null) {
                mark('L');
                traverse(node.left, start, dest);
                mark('l');
            }
            if (node.right != null) {
                mark('R');
                traverse(node.right, start, dest);
                mark('r');
            }
        }
    }
}