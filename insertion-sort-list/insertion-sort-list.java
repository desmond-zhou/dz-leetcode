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
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = null;
        
        while (head != null) {
            ListNode select = head;
            head = select.next;
            newHead = insert(newHead, select);
        }
        
        return newHead;
    }
    
    private ListNode insert(ListNode newHead, ListNode select) {
        select.next = null;
        if (newHead == null) {
            newHead = select;
            return newHead;
        } else if (select.val < newHead.val) {
            select.next = newHead;
            newHead = select;
            return newHead;
        } else {
            ListNode par = newHead;
            while (par.next != null) {
                if (select.val >= par.val && select.val < par.next.val) {
                    select.next = par.next;
                    par.next = select;
                    return newHead;
                }
                par = par.next;
            }
            par.next = select;
            return newHead;
        }
    }
}