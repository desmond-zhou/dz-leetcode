/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node tail = search(head);
        return head;
    }
    
    private Node search(Node head) {
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            if (cur.child != null) {
                Node child = cur.child;
                Node childTail = search(cur.child);
                Node originalNext = cur.next;
                cur.next = child;
                child.prev = cur;
                childTail.next = originalNext;
                if (originalNext != null) originalNext.prev = childTail;
                cur.child = null;
                
                // advance to last processed node
                cur = childTail; 
            } 
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
}