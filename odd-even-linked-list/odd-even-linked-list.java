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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        
        
        ListNode curOdd = head;
        ListNode curEven = head.next;
        ListNode evenTip = curEven;
        
        ListNode curProcess = curEven.next;

        boolean isOdd = true;
        while (curProcess != null) {
            if (isOdd) {
                curOdd.next = curProcess;
                curOdd = curProcess;
            } else {
                curEven.next = curProcess;
                curEven = curProcess;
            }
            
            isOdd = !isOdd;
            curProcess = curProcess.next;
        }
        
        curOdd.next = evenTip;
        curEven.next = null;

        return head;
    }
}