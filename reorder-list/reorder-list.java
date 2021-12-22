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
    public void reorderList(ListNode head) {
        ListNode mid = findCutMid(head);
        ListNode reverse = reverse(mid);
        splice(head, reverse);
    }
    
    private ListNode findCutMid(ListNode head) {
        int size = 0;
        for (ListNode n = head; n != null; n = n.next) size++;
        int half = size / 2;
        ListNode firstTail = head;
        for (int i = 1; i < half; i++) firstTail = firstTail.next;
        ListNode mid = firstTail.next;
        firstTail.next = null;
        return mid;
    }
    
    //1234
    //21 
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
    //123
    //abc
    private ListNode splice(ListNode a, ListNode b) {
        ListNode curA = a;
        ListNode curB = b;
        
        while (curA != null && curB != null) {
            ListNode nextA = curA.next;
            ListNode nextB = curB.next;
            curA.next = curB;
            if (nextA == null) {
                curB.next = nextB;
                break;
            } 
            curB.next = nextA;
            curA = nextA;
            curB = nextB;
        }
        
        return a;
    }
}

// 12345 => 15243 = 123/54
// 123456 => 162534 = 123/654