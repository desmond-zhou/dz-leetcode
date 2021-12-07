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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        tail.next = head;
        int leftShift = length - (k % length);
        
        ListNode prev = null;
        ListNode cur = head;
        for (int i = 0; i < leftShift; i++) {
            prev = cur;
            cur = cur.next;
        }
        
        prev.next = null;
        return cur;
    }
}