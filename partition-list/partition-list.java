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
    public ListNode partition(ListNode head, int x) {
        ListNode smallR = new ListNode(0);
        ListNode largeR = new ListNode(0);
        ListNode smallCur = smallR;
        ListNode largeCur = largeR;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                smallCur.next = cur;
                smallCur = cur;
            } else {
                largeCur.next = cur;
                largeCur = cur;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        smallCur.next = largeR.next;
        return smallR.next;
    }
}