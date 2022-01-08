/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode intersection(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (f == s) {
                return s;
            }
        }
        return null;
    }
    
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode inter = intersection(head);
        if (inter == null) return null;
        ListNode o = head;
        ListNode i = inter;
        while (o != i) {
            o = o.next;
            i = i.next;
        }
        return o;
    }
}