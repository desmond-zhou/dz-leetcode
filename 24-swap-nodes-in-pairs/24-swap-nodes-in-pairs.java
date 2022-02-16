
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

//0 12 34
//0 21 43
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode sent = new ListNode(0);
        sent.next = head;
        
        ListNode cur = sent;
        while (cur != null && cur.next != null && cur.next.next != null) {
            ListNode s1 = cur.next;
            ListNode s2 = s1.next;
            ListNode s3 = s2.next;
        
            cur.next = s2;
            s2.next = s1;
            s1.next = s3;
            
            cur = s1;
        }
        return sent.next;
    }
}