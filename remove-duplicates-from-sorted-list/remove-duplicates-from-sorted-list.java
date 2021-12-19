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
// cur: 1123
// cVH: 123
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode curValueHead = null;
        while (cur != null) {
            if (curValueHead == null) curValueHead = cur;
            if (cur.val != curValueHead.val) {
                    curValueHead.next = cur;
                    curValueHead = cur;                
            }
            cur = cur.next;
        }
        curValueHead.next = null; //BUG: loop termination.
        
        return head;
    }
}