/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node newRoot = new Node(node.val);
        map.put(node, newRoot);
        clone(node, map);
        return newRoot;
    }
    
    private void clone(Node node, HashMap<Node, Node> map) {
        Node target = map.get(node);
        for (Node n : node.neighbors) {
            if (map.containsKey(n)) target.neighbors.add(map.get(n));
            else {
                Node newN = new Node(n.val);
                map.put(n, newN);
                target.neighbors.add(map.get(n));
                clone(n, map);
            }
        }
    }
}