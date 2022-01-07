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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        left++;
        right++;
        
        ListNode p = null;
        ListNode cur = head;
        for (int i = 2; i < left; i++) {
            p = cur;
            cur = cur.next;
        }
        
        ListNode segS = p;
        ListNode rS = cur;
        
        p = null;
        for (int i = left; i <= right; i++) {
            ListNode next = cur.next;
            cur.next = p;
            p = cur;
            cur = next;
        }
        
        ListNode rE = p;
        ListNode SegE = cur;
        
        if (segS != null) {
            segS.next = rE;
        } else {
            dummy.next = rE;
        }
        rS.next = SegE;
        
        return dummy.next;
    }
}