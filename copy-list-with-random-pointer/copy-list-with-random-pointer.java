/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node nHead = null;
        Node nCur = null;
        Node cur = head;
        while (cur != null) {
            if (nHead == null) {
                nHead = clone(cur, map);
                nCur = nHead;
            }
            nCur.next = clone(cur.next, map);
            cur = cur.next;
            nCur = nCur.next;
        }
        
        nCur = nHead;
        cur = head;
        while (cur != null) {
            nCur.random = map.get(cur.random);
            cur = cur.next;
            nCur = nCur.next;
        }
        
        return nHead;
    }
    
    private Node clone(Node n, HashMap<Node, Node> map) {
        if (n == null) return null;
        if (map.containsKey(n)) return map.get(n);
        Node c = new Node(n.val);
        map.put(n, c);
        return c;
    }
}