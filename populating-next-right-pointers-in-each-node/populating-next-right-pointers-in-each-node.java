/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        ArrayDeque<Node> q = new ArrayDeque<>();
        HashMap<Node, Integer> levels = new HashMap<>();
        levels.put(root, 0);
        q.offer(root);
        Node prev = null;
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (prev != null && levels.get(prev) == levels.get(n)) {
                prev.next = n; 
            }
            if (n.left != null) {
                levels.put(n.left, levels.get(n) + 1);
                q.offer(n.left);
            }
            if (n.right != null) {
                levels.put(n.right, levels.get(n) + 1);
                q.offer(n.right);
            }
            prev = n;
        }
        return root;
    }
}