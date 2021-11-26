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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        
        int curDigit = 0;
        int curCarry = 0;
        ListNode curNode = root;
        ListNode curL1 = l1;
        ListNode curL2 = l2;
        while (true) {
            if (curL1 == null && curL2 == null) break;
            
            int valL1 = (curL1 == null) ? 0 : curL1.val;
            int valL2 = (curL2 == null) ? 0 : curL2.val;
            
            int sum = valL1 + valL2 + curCarry;
            curCarry = (sum / 10);
            ListNode newNode = new ListNode(sum % 10);
            curNode.next = newNode;
            curNode = newNode;
            
            curL1 = (curL1 == null || curL1.next == null) ? null : curL1.next;
            curL2 = (curL2 == null || curL2.next == null) ? null : curL2.next;
        }
        
        if (curCarry > 0) {
            ListNode newNode = new ListNode(curCarry);
            curNode.next = newNode;
            curNode = newNode;
        }
        
        return root.next;
    }
}