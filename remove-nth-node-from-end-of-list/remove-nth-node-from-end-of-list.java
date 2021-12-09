/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(0, head);
        countFromEnd(fakeHead, null, n);
        return fakeHead.next;
    }
    
    public int countFromEnd(ListNode node, ListNode parent, int indexToRemove) {
        if (node == null) return 0;
        int curCountFromEnd = countFromEnd(node.next, node, indexToRemove) + 1;
        
        if (curCountFromEnd == indexToRemove) {
            parent.next = node.next;
            node.next = null;
        }
        
        return curCountFromEnd;
    }
}